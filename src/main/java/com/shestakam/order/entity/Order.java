package com.shestakam.order.entity;

import com.shestakam.order.orderItem.entity.OrderItem;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shestakam on 16.9.15.
 */
@Entity
@Table(name = "order" ,catalog = "coffeeMarket")
public class Order {

    private Long id;
    private Set<OrderItem> orderItemSet = new HashSet<>(0);
    private String username;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(Set<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
