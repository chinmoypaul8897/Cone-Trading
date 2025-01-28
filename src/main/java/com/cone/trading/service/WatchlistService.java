package com.cone.trading.service;

import com.cone.trading.model.Coin;
import com.cone.trading.model.User;
import com.cone.trading.model.Watchlist;

public interface WatchlistService {

    Watchlist findUserWatchList (Long userId ) throws Exception;

    Watchlist createWatchlist( User user);

    Watchlist findById(Long id ) throws Exception;

    Coin addItemToWatchlist(Coin coin , User user) throws Exception;









}
