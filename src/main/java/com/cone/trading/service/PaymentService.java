package com.cone.trading.service;

import com.cone.trading.domain.PaymentMethod;
import com.cone.trading.model.PaymentOrder;
import com.cone.trading.model.User;
import com.cone.trading.response.PaymentResponse;
import org.springframework.security.core.parameters.P;

public interface PaymentService {


    PaymentOrder createOrder (User user , Long amount , PaymentMethod paymentMethod);

    PaymentOrder getPaymentOrderById (Long id ) throws Exception;

    Boolean ProccedPaymentOrderById (PaymentOrder paymentOrder , String  paymentId );

    PaymentResponse createRazorpayPaymentLink(User user , Long amount );

    PaymentResponse createStripePaymentLink(User user , Long amount , Long orderId );








}
