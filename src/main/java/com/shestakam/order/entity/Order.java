package com.shestakam.order.entity;

import com.shestakam.order.orderItem.entity.OrderItem;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Public class <code>Order</code> is one of entities
 * classes. Its content is fully consistent with Table user_order
 * in database, which we use for. The main role is to store
 * associated with the table information(data).
 */
@Entity
@Table(name = "user_order" ,catalog = "coffeeMarket")
public class Order {


    /**
     * unique identifier of instance
     */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /**
     * parameter which contains order items for this order
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Set<OrderItem> orderItemSet = new HashSet<>(0);

    /**
     * parameter describe username who made order
     */
    @Column(name = "username",nullable = false,length = 40)
    private String username;

    /**
     * parameter describe address of user
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (orderItemSet != null ? !orderItemSet.equals(order.orderItemSet) : order.orderItemSet != null) return false;
        if (username != null ? !username.equals(order.username) : order.username != null) return false;
        if (address != null ? !address.equals(order.address) : order.address != null) return false;
        return !(totalPrice != null ? !totalPrice.equals(order.totalPrice) : order.totalPrice != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (orderItemSet != null ? orderItemSet.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }
}
