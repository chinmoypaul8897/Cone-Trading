package com.cone.trading.model;

import lombok.Data;

import java.lang.ref.PhantomReference;

@Data
public class TwoFactorAuth {
    private boolean isEnabled = false ;
    private VerificationType sendTo;
}
