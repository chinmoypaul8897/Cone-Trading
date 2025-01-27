package com.cone.trading.service;

import com.cone.trading.model.Order;
import com.cone.trading.model.User;
import com.cone.trading.model.Wallet;

public interface WalletService {
    Wallet getUserWallet(User user );
    Wallet addBalance(Wallet wallet , Long money);
    Wallet findWalletById(Long id );
    Wallet walletToWalletTransfer(User sender , Wallet recieverWallet , Long amount );
    Wallet payOrderPayment(Order order , User user );


}
