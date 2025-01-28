package com.cone.trading.controller;

import com.cone.trading.model.Coin;
import com.cone.trading.model.User;
import com.cone.trading.model.Watchlist;
import com.cone.trading.service.CoinService;
import com.cone.trading.service.UserService;
import com.cone.trading.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/watchlist")
public class WatchlistController {

    @Autowired
    private WatchlistService watchlistService;

    @Autowired
    private UserService userService;

    @Autowired
    private CoinService coinService;

    @GetMapping("/user")
    public ResponseEntity<Watchlist> getUserWatchlist(
        @RequestHeader("Authorization") String jwt ) throws Exception
    {
        User user = userService.findUserProfileByJwt(jwt);
        Watchlist watchlist = watchlistService.findUserWatchList(user.getId());
        return ResponseEntity.ok(watchlist);
    }

   @GetMapping("/{watchlistId}")
    public ResponseEntity<Watchlist> getWatchlistById(
            @PathVariable Long watchlistId ) throws Exception{

        Watchlist watchlist = watchlistService.findById(watchlistId);
        return ResponseEntity.ok(watchlist);

   }

   @PatchMapping("/add/coin/{coinId}")
    public ResponseEntity<Coin> addItemToWatchlist(
            @RequestHeader("Authorization") String jwt ,
            @PathVariable String coinId ) throws Exception
   {
       User user = userService.findUserProfileByJwt(jwt);

       Coin coin = coinService.findById(coinId);

       Coin addedCoin = watchlistService.addItemToWatchlist(coin,user);

       return ResponseEntity.ok(addedCoin);
   }




}
