package com.cone.trading.service;

import com.cone.trading.model.Coin;
import com.cone.trading.model.User;
import com.cone.trading.model.Watchlist;
import com.cone.trading.repository.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    @Autowired
    private WatchlistRepository watchlistRepository;





    @Override
    public Watchlist findUserWatchList(Long userId) throws Exception {
        Watchlist watchlist = watchlistRepository.findByUserId(userId);
        if (watchlist==null)
        {
            throw  new Exception("Watchlist not found ");
        }
        return watchlist;
    }

    @Override
    public Watchlist createWatchlist(User user) {
        Watchlist watchlist = new Watchlist();
        watchlist.setUser(user);

        return watchlistRepository.save(watchlist);
    }

    @Override
    public Watchlist findById(Long id) throws Exception {

        Optional<Watchlist> watchlistOptional = watchlistRepository.findById(id);
        if (watchlistOptional.isEmpty())
        {
            throw new Exception("Watchlist not found ");
        }

        return watchlistOptional.get();
    }

    @Override
    public Coin addItemToWatchlist(Coin coin, User user) throws Exception {
       Watchlist watchlist = findUserWatchList(user.getId());
       if (watchlist.getCoins().contains(coin))
       {
           watchlist.getCoins().remove(coin);
       }
       else {
           watchlist.getCoins().add(coin);
       }

       watchlistRepository.save(watchlist);
        return coin ;
    }
}
