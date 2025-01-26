package com.cone.trading.repository;

import com.cone.trading.model.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  VerificationCodeRepository extends JpaRepository <VerificationCode,Long>{

    public VerificationCode findByUserId (Long userId );


}
