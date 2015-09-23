package com.shestakam.order.entity;

import com.shestakam.order.orderItem.entity.OrderItem;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shestakam on 16.9.15.
 */
@Entity
@Table(name = "user_order" ,catalog = "coffeeMarket")
public class Order {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Set<OrderItem> orderItemSet = new HashSet<>(0);

    @Column(name = "username",nullable = false,length = 40)
    private String username;

    @Column(name = "address",nullable = false,length = 50)
    private String address;

    @Column(name = "total_price")
    private Integer totalPrice;

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

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
