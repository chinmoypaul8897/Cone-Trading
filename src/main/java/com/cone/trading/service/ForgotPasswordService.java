package com.cone.trading.service;

import com.cone.trading.domain.VerificationType;
import com.cone.trading.model.ForgotPasswordToken;
import com.cone.trading.model.User;

public interface ForgotPasswordService {

    ForgotPasswordToken createToken (User user ,
                                     String id , String otp ,
                                     VerificationType verificationType ,
                                     String sendTo );

    ForgotPasswordToken findById (String id );

    ForgotPasswordToken findByUser (Long userId);

    void deleteToken (ForgotPasswordToken token );


}
