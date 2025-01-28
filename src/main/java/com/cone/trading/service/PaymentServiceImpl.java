package com.cone.trading.service;

import com.cone.trading.domain.PaymentMethod;
import com.cone.trading.model.PaymentOrder;
import com.cone.trading.model.User;
import com.cone.trading.response.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired





    @Override
    public PaymentOrder createOrder(User user, Long amount, PaymentMethod paymentMethod) {
        return null;
    }

    @Override
    public PaymentOrder getPaymentOrderById(Long id) {
        return null;
    }

    @Override
    public Boolean ProccedPaymentOrderById(PaymentOrder paymentOrder, String paymentId) {
        return null;
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
