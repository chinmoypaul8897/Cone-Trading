package com.cone.trading.service;

import com.cone.trading.domain.WalletTransactionType;
import com.cone.trading.model.Wallet;
import com.cone.trading.model.WalletTransaction;
import com.cone.trading.repository.WalletTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private WalletTransactionRepository transactionRepository;

    @Autowired
    private WalletService walletService; // If needed to fetch wallet details

    @Override
    public List<WalletTransaction> getTransactionsByWallet(Wallet wallet) {
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet cannot be null");
        }
        return transactionRepository.findByWallet(wallet);
    }

    @Override
    public WalletTransaction createTransaction(Wallet wallet, WalletTransactionType transactionType, String description, Long amount) {
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet cannot be null");
        }
        if (transactionType == null) {
            throw new IllegalArgumentException("Transaction type cannot be null");
        }
        if (amount == null || amount.compareTo(0L) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        WalletTransaction transaction = new WalletTransaction();
        transaction.setWallet(wallet);
        transaction.setTransactionType(transactionType);
        transaction.setDescription(description);
        transaction.setAmount(amount);

        // Save the transaction to the database
        return transactionRepository.save(transaction);
    }

}
