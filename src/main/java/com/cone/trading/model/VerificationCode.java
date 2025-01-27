package com.cone.trading.model;

import com.cone.trading.domain.VerificationType;
import jakarta.persistence.*;
import lombok.Data;

import javax.naming.ldap.PagedResultsControl;


@Data
@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public VerificationType getVerificationType() {
        return verificationType;
    }

    public void setVerificationType(VerificationType verificationType) {
        this.verificationType = verificationType;
    }

    @Override
    public String toString() {
        return "VerificationCode{" +
                "id=" + id +
                ", otp='" + otp + '\'' +
                ", user=" + user +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", verificationType=" + verificationType +
                '}';
    }
}
