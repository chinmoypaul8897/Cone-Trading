package com.cone.trading.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class WalletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @ManyToOne
    private Wallet wallet;

    private WalletTransactionType  type ;





}
