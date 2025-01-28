package com.cone.trading.repository;

import com.cone.trading.model.Order;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long > {
    List<Order> findByUserId (Long userId );

}
