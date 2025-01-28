package com.cone.trading.service;

import com.cone.trading.domain.OrderType;
import com.cone.trading.model.Coin;
import com.cone.trading.model.Order;
import com.cone.trading.model.OrderItem;
import com.cone.trading.model.User;

import java.util.List;

public interface OrderService {

    Order createOrder (User user , OrderItem orderItem , OrderType orderType);

    Order getOrderById (Long orderId ) throws Exception;

    List<Order> getAllOrderOfUser (Long  userId , OrderType orderType , String assetSymbol  );

    Order processOrder (Coin coin , double quantity , OrderType orderType , User user ) throws Exception;



}
