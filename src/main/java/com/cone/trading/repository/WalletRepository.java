package com.cone.trading.repository;

import com.cone.trading.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {
    Wallet findByUserId(Long userId );

}
