package com.cone.trading.model;

import com.cone.trading.domain.VerificationType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ForgotPasswordToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @OneToOne
    private User user ;

    private String otp ;

    private VerificationType verificationType;

    private String sendTo ;


}
