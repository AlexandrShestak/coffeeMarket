package com.shestakam.order.orderItem.entity;

import com.shestakam.coffee.brand.entity.CoffeeBrand;
import com.shestakam.order.entity.Order;
import org.codehaus.jackson.annotate.JsonIgnore;

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
    @JsonIgnore
    private Long id;

   /* @Column(name = "brand",nullable = false, length = 20)
    private String brand;

    @Column(name = "price",nullable = false)
    private  int price;*/

    @Column(name = "brand_id",nullable = false)
    private Long brandId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false , insertable = false , updatable = false)
    @JsonIgnore
    private CoffeeBrand brand;

    @Column(name = "count",nullable = false)
    private int count;

    @Column(name = "order_id",nullable = false)
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false , insertable = false , updatable = false)
    @JsonIgnore
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CoffeeBrand getBrand() {
        return brand;
    }

    public void setBrand(CoffeeBrand brand) {
        this.brand = brand;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}
