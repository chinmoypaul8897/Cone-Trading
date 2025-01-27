package com.cone.trading.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id ;
    @ManyToOne
    private User user ;

    private OrderType orderType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                '}';
    }
}
