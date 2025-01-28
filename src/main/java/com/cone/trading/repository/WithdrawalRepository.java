package com.cone.trading.repository;

import com.cone.trading.model.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WithdrawalRepository  extends JpaRepository<Withdrawal , Long> {

    List<Withdrawal> findByUserId (Long userId );


}
