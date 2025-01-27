package com.cone.trading.service;

import com.cone.trading.model.Order;
import com.cone.trading.model.User;
import com.cone.trading.model.Wallet;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {




    @Override
    public Wallet getUserWallet(User user) {
        return null;
    }

    @Override
    public Wallet addBalance(Wallet wallet, Long money) {
        return null;
    }

    @Override
    public Wallet findWalletById(Long id) {
        return null;
    }

    @Override
    public Wallet walletToWalletTransfer(User sender, Wallet recieverWallet, Long amount) {
        return null;
    }

    @Override
    public Wallet payOrderPayment(Order order, User user) {
        return null;
    }
}
