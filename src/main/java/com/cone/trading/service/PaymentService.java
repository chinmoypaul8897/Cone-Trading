package com.cone.trading.service;

import com.cone.trading.domain.PaymentMethod;
import com.cone.trading.model.PaymentOrder;
import com.cone.trading.model.User;
import org.springframework.security.core.parameters.P;

public interface PaymentService {


    PaymentOrder createOrder (User user , Long amount , PaymentMethod paymentMethod);

    PaymentOrder getPaymentOrderById (Long id );

    Boolean proccedPaymentOrderById (PaymentOrder paymentOrder , String  paymentId );

    PaymentResponse createRazorpayPaymentLink(User user , Long amount );







}
