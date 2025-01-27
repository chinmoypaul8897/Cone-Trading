package com.cone.trading.request;

import com.cone.trading.domain.VerificationType;
import com.cone.trading.model.VerificationCode;

public class ForgotPasswordTokenRequest {

    private String sendTo ;
    private VerificationType verificationType;

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public VerificationType getVerificationType() {
        return verificationType;
    }

    public void setVerificationType(VerificationType verificationType) {
        this.verificationType = verificationType;
    }

    @Override
    public String toString() {
        return "ForgotPasswordTokenRequest{" +
                "sendTo='" + sendTo + '\'' +
                ", verificationType=" + verificationType +
                '}';
    }
}
