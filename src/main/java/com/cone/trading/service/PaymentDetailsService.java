package com.cone.trading.service;

import com.cone.trading.model.PaymentDetails;
import com.cone.trading.model.User;

public interface PaymentDetailsService {

    public PaymentDetails addPaymentDetails(String accountNumber,
                                            String accountHolderName,
                                            String ifsc,
                                            String bankName,
                                            User user);


    public PaymentDetails getUsersPaymentDetails(User user);

}
