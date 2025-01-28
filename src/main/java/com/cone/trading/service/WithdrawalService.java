package com.cone.trading.service;

import com.cone.trading.model.User;
import com.cone.trading.model.Withdrawal;

import java.util.List;

public interface WithdrawalService {

    Withdrawal reqestWithdrawal (Long amount , User user);

    Withdrawal proceedWithdrawal(Long withdrawalId, boolean accept );

    List<Withdrawal> getUsersWithdrawalHistory(User user);

    List<Withdrawal> getAllWithdrawalRequest();






}
