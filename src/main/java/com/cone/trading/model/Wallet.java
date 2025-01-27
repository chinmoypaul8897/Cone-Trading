package com.cone.trading.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @OneToOne
    private User user;

    private BigDecimal balance ;


}
