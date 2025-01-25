package com.cone.trading.model;

import com.cone.trading.domain.VerificationType;
import lombok.Data;

import java.lang.ref.PhantomReference;

@Data
public class TwoFactorAuth {
    private boolean isEnabled = false ;
    private VerificationType sendTo;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public VerificationType getSendTo() {
        return sendTo;
    }

    public void setSendTo(VerificationType sendTo) {
        this.sendTo = sendTo;
    }

    @Override
    public String toString() {
        return "TwoFactorAuth{" +
                "isEnabled=" + isEnabled +
                ", sendTo=" + sendTo +
                '}';
    }
}
