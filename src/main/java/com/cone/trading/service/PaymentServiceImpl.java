package com.cone.trading.service;

import com.cone.trading.domain.PaymentMethod;
import com.cone.trading.domain.PaymentOrderStatus;
import com.cone.trading.model.PaymentOrder;
import com.cone.trading.model.User;
import com.cone.trading.repository.PaymentOrderRepository;
import com.cone.trading.response.PaymentResponse;
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
    public Boolean ProccedPaymentOrderById(PaymentOrder paymentOrder, String paymentId) {
        if (paymentOrder.getStatus().equals(PaymentOrderStatus.PENDING))
        {
            if (paymentOrder.getPaymentMethod().equals(PaymentMethod.RAZORPAY))
            {
                
            }
        }
    }

    @Override
    public PaymentResponse createRazorpayPaymentLink(User user, Long amount) {
        return null;
    }

    @Override
    public PaymentResponse createStripePaymentLink(User user, Long amount, Long orderId) {
        return null;
    }
}
