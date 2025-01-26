package com.cone.trading.model;

import com.cone.trading.domain.VerificationType;
import jakarta.persistence.*;
import lombok.Data;

import javax.naming.ldap.PagedResultsControl;

@Entity
@Data
public class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @OneToOne
    private String otp ;

    private User user ;

    private String email ;
    private String mobile ;
    private VerificationType verificationType;



}
