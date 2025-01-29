package com.cone.trading.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private double quantity ;
    private double buyPrice ;

    @ManyToOne
    private Coin coin ;
    @ManyToOne
    private User user;

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", buyPrice=" + buyPrice +
                ", coin=" + coin +
                ", user=" + user +
                '}';
    }
}
