package com.shestakam.coffee.brand.entity;

import com.shestakam.order.orderItem.entity.OrderItem;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shestakam on 8.9.15.
 */
@Entity
@Table(name = "coffee_brand" ,catalog = "coffeeMarket")
public class CoffeeBrand {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name",unique = true, nullable = false, length = 20)
    private String name;

    @Column(name = "price",nullable = false)
    private Integer price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
    private Set<OrderItem> orderItemSet = new HashSet<>(0);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
