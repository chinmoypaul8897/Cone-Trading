package com.cone.trading.service;

import com.cone.trading.domain.PaymentMethod;
import com.cone.trading.domain.PaymentOrderStatus;
import com.cone.trading.model.PaymentOrder;
import com.cone.trading.model.User;
import com.cone.trading.repository.PaymentDetailsRepository;
import com.cone.trading.repository.PaymentOrderRepository;
import com.cone.trading.response.PaymentResponse;
import com.razorpay.Payment;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.IllegalFormatCodePointException;

@Service
public class PaymentServiceImpl implements PaymentService {



    @Autowired
    private PaymentOrderRepository paymentOrderRepository ;

    @Value("${stripe.api.key}")
    private String stripeSecretKey ;

    @Value("${razorpay.api.key}")
    private String apiKey ;

    @Value("${razorpay.api.secret}")
    private String apiSecretKey ;



    @Override
    public PaymentOrder createOrder(User user, Long amount, PaymentMethod paymentMethod) {
       PaymentOrder paymentOrder = new PaymentOrder();
       paymentOrder.setUser(user);
       paymentOrder.setAmount(amount);
       paymentOrder.setPaymentMethod(paymentMethod);

       return paymentOrderRepository.save(paymentOrder);

    }

    @Override
    public PaymentOrder getPaymentOrderById(Long id) throws Exception {
        return paymentOrderRepository.findById(id).orElseThrow(() -> new Exception("payment order not found "));
    }

    @Override
    public Boolean ProccedPaymentOrderById(PaymentOrder paymentOrder, String paymentId) throws RazorpayException {
        if (paymentOrder.getStatus().equals(PaymentOrderStatus.PENDING))
        {
            if (paymentOrder.getPaymentMethod().equals(PaymentMethod.RAZORPAY))
            {
                RazorpayClient razorpay = new RazorpayClient(apiKey , apiSecretKey);

                Payment payment = razorpay.payments.fetch(paymentId);

                Integer amount = payment.get("amount");

                String status = payment.get("status");

                if (status.equals("captured"))
                {
                    paymentOrder.setStatus(PaymentOrderStatus.SUCCESS);
                    return true ;
                }
                paymentOrder.setStatus(PaymentOrderStatus.FAILED);
                paymentOrderRepository.save(paymentOrder);
                return false ;


            }
            paymentOrder.setStatus(PaymentOrderStatus.SUCCESS);
            paymentOrderRepository.save(paymentOrder);
            return true ;
        }
        return false ;
    }

    @Override
    public PaymentResponse createRazorpayPaymentLink(User user, Long amount) throws RazorpayException {
        Long Amount = amount * 100 ;

        try{
            RazorpayClient razorpay = new RazorpayClient(apiKey,apiSecretKey);


            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount",amount);
            paymentLinkRequest.put("currency","INR");

            JSONObject customer = new JSONObject();
            customer.put("name",user.getFullName());

            customer.put("email" , user.getEmail());
            paymentLinkRequest.put("customer",customer);

            JSONObject notify = new JSONObject();
            notify.put("email",true);
            paymentLinkRequest.put("notify",notify);

            paymentLinkRequest.put("reminder_enable",true);

            paymentLinkRequest.put("callback_url","http://localhost:5173/wallet" );
            paymentLinkRequest.put("callback_method","get");

            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);

            String paymentLinkId = payment.get("id");
            String paymentLinkUrl = payment.get("short_url");

            PaymentResponse res = new PaymentResponse();
            res.setPayment_url(paymentLinkUrl);


            return res ;

        } catch (RazorpayException e) {
            System.out.println("Error creating Payment link " + e.getMessage());
            throw new RazorpayException(e.getMessage());
        }
    }

    @Override
    public PaymentResponse createStripePaymentLink(User user, Long amount, Long orderId) {
        return null;
    }
}
