package com.cone.trading.controller;

import com.cone.trading.model.Coin;
import com.cone.trading.model.Order;
import com.cone.trading.model.User;
import com.cone.trading.model.WalletTransaction;
import com.cone.trading.service.CoinService;
import com.cone.trading.service.OrderService;
import com.cone.trading.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private CoinService coinService;

//    @Autowired
//    private WalletTransactionService walletTransactionService;

    @PostMapping("/pay")
    public ResponseEntity<Order> payOrderPayment (
            @RequestHeader("Authprization") String jwt ,
            @RequestBody CreateOrderRequest req
    ) throws Exception
    {
        User user = userService.findUserProfileByJwt(jwt);
        Coin coin = coinService.findById(req.getCoinId());
    }

}
