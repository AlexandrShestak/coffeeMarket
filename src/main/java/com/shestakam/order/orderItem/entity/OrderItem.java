package com.shestakam.order.orderItem.entity;

import com.shestakam.coffee.brand.entity.CoffeeBrand;
import com.shestakam.order.entity.Order;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.*;


/**
 * Public class <code>OrderItem</code> is one of Entities
 * classes. Its content is fully consistent with Table order_item
 * in data base, which we use for. The main role is to store
 * associated with the table information(data).
 */
@Entity
@Table(name = "order_item" ,catalog = "coffeeMarket")
public class OrderItem {

    /**
     * unique identifier of instance
     */
    @Id
    @GeneratedValue
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    /**
     * parameter contains brand id
     */
    @Column(name = "brand_id",nullable = false)
    private Long brandId;


    /**
     * parameter contains brand
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false , insertable = false , updatable = false)
    @JsonIgnore
    private CoffeeBrand brand;

    /**
     * parameter describe amount of coffee with appropriate brand
     */
    @Column(name = "amount",nullable = false)
    private int amount;


    /**
     * parameter contains order id
     */
    @Column(name = "order_id",nullable = false)
    private Long orderId;


    /**
     * parameter contains order
     */
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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public CoffeeBrand getBrand() {
        return brand;
    }

    public void setBrand(CoffeeBrand brand) {
        this.brand = brand;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (amount != orderItem.amount) return false;
        if (id != null ? !id.equals(orderItem.id) : orderItem.id != null) return false;
        if (brandId != null ? !brandId.equals(orderItem.brandId) : orderItem.brandId != null) return false;
        if (brand != null ? !brand.equals(orderItem.brand) : orderItem.brand != null) return false;
        if (orderId != null ? !orderId.equals(orderItem.orderId) : orderItem.orderId != null) return false;
        return !(order != null ? !order.equals(orderItem.order) : orderItem.order != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brandId != null ? brandId.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }
}
