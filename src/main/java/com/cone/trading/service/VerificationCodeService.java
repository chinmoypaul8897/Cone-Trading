package com.cone.trading.service;

import com.cone.trading.model.VerificationCode;

public interface VerificationCodeService {
    VerificationCode sendVerificationCode (VerificationCode verificationCode);

    VerificationCode getVerificationCodeById (Long id );

    VerificationCode getVerificationCodeByUser(Long userId );

    void deleteVerificationCodeById (VerificationCode verificationCode);


}
