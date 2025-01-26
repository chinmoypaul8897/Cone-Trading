package com.cone.trading.service;

import com.cone.trading.domain.VerificationType;
import com.cone.trading.model.User;
import com.cone.trading.model.VerificationCode;

public interface VerificationCodeService {
    VerificationCode sendVerificationCode (User user , VerificationType verificationType);

    VerificationCode getVerificationCodeById (Long id ) throws Exception;

    VerificationCode getVerificationCodeByUser(Long userId );



    void deleteVerificationCodeById (VerificationCode verificationCode);


}
