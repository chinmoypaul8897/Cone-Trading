package com.cone.trading.model;


import com.cone.trading.domain.PaymentMethod;
import com.cone.trading.domain.PaymentOrderStatus;
import com.fasterxml.jackson.core.Base64Variant;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PaymentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private Long amount ;

    private PaymentOrderStatus status;

    private PaymentMethod paymentMethod;

    @ManyToOne
    private User user;
}
