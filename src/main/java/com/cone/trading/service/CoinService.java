package com.cone.trading.service;

import com.cone.trading.model.Coin;

import java.util.List;

public interface CoinService {

    List<Coin> getCoinList(int page ) throws Exception;

    String getMarketChart(String coinId , int days ) throws Exception;

    String getCoinDetails (String coinId) throws Exception;

    Coin findById (String coinId ) throws Exception;

    String searchCoin (String keyword);

    String getTop50CoinsByMarketCapRank();


    String GetTradingCoins();




}
