package com.cone.trading.service;

import com.cone.trading.model.Coin;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CoinServiceImpl implements CoinService {
    @Override
    public List<Coin> getCoinList(int page) {
        return null;
    }

    @Override
    public String getMarketChart(String coinId, int days) {
        return null;
    }

    @Override
    public String getCoinDetails(String coinId) {
        return null;
    }

    @Override
    public Coin findById(String coinId) {
        return null;
    }

    @Override
    public String searchCoin(String keyword) {
        return null;
    }

    @Override
    public String getTop50CoinsByMarketCapRank() {
        return null;
    }

    @Override
    public String GetTradingCoins() {
        return null;
    }
}
