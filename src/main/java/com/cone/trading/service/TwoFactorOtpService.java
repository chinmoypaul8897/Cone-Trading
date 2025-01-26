package com.cone.trading.service;

import com.cone.trading.model.TwoFactorOTP;
import com.cone.trading.model.User;

public interface TwoFactorOtpService {
    TwoFactorOTP createTwoFactorOtpService(User user , String otp , String jwt  );


    TwoFactorOTP findByUser (Long userId);

    TwoFactorOTP findById (String id );

    boolean verifyTwoFactorOtp (TwoFactorOTP twoFactorOtp , String otp  );

    void deleteTwoFactorOtp(TwoFactorOTP twoFactorOtp);



}
