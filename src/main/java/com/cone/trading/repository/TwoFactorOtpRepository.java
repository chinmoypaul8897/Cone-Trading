package com.cone.trading.repository;

import com.cone.trading.model.TwoFactorOTP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TwoFactorOtpRepository extends JpaRepository<TwoFactorOTP , String> {

    TwoFactorOTP findByUserId (Long userId );
}
