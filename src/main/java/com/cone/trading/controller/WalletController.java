package com.cone.trading.controller;

import com.cone.trading.model.User;
import com.cone.trading.model.Wallet;
import com.cone.trading.service.UserService;
import com.cone.trading.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @Autowired
    private UserService userService;

    @GetMapping("api/wallet")
    public ResponseEntity<Wallet> getUserWallet (@RequestHeader("Authorization") String jwt ) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);

        Wallet wallet = walletService.getUserWallet(user);

        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);


    }

    public ResponseEntity<Wallet> walletToWalletTransfer (
            @RequestHeader("Authorization") String jwt ,
            @PathVariable Long walletId )
            throws Exception
    {

    }


}
