package com.cone.trading.repository;

import com.cone.trading.model.PaymentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PaymentOrderRepository extends JpaRepository<PaymentOrder , Long > {




}
