package com.cone.trading.model;

import com.cone.trading.domain.VerificationType;
import jakarta.persistence.*;
import lombok.Data;

//@Data
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public VerificationType getVerificationType() {
        return verificationType;
    }

    public void setVerificationType(VerificationType verificationType) {
        this.verificationType = verificationType;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    @Override
    public String toString() {
        return "ForgotPasswordToken{" +
                "id=" + id +
                ", user=" + user +
                ", otp='" + otp + '\'' +
                ", verificationType=" + verificationType +
                ", sendTo='" + sendTo + '\'' +
                '}';
    }
}
