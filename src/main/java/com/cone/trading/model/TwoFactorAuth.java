package com.cone.trading.model;

import com.cone.trading.domain.VerificationType;
import lombok.Data;

import java.lang.ref.PhantomReference;

@Data
public class TwoFactorAuth {
    private boolean isEnabled = false ;
    private VerificationType sendTo;
}
