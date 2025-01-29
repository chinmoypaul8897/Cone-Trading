package com.cone.trading.service;

import com.cone.trading.domain.WalletTransactionType;
import com.cone.trading.model.Wallet;
import com.cone.trading.model.WalletTransaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    List<WalletTransaction> getTransactionsByWallet(Wallet wallet);

    WalletTransaction createTransaction(Wallet wallet, WalletTransactionType transactionType, String description, Long amount);
}
