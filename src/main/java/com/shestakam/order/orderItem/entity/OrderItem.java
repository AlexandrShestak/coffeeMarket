package com.shestakam.order.orderItem.entity;

import javax.persistence.Entity;
import javax.persistence.*;


/**
 * Created by shestakam on 20.9.15.
 */
@Entity
@Table(name = "order_item" ,catalog = "coffeeMarket")
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "brand",nullable = false, length = 20)
    private String brand;

    @Column(name = "price",nullable = false)
    private  int price;

    @Column(name = "count",nullable = false)
    private int count;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
