package com.cone.trading.repository;

import com.cone.trading.model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails , Long > {

    PaymentDetails findByUserId (Long userId );
}
