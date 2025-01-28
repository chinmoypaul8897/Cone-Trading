package com.cone.trading.service;

import com.cone.trading.model.User;
import com.cone.trading.model.Withdrawal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WithdrawalServiceImpl  implements WithdrawalService{


    private


    @Override
    public Withdrawal reqestWithdrawal(Long amount, User user) {
        return null;
    }

    @Override
    public Withdrawal proceedWithdrawal(Long withdrawalId, boolean accept) {
        return null;
    }

    @Override
    public List<Withdrawal> getUsersWithdrawalHistory(User user) {
        return null;
    }

    @Override
    public List<Withdrawal> getAllWithdrawalRequest() {
        return null;
    }
}
