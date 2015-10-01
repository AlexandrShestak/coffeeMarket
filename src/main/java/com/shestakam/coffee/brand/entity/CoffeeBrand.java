package com.shestakam.coffee.brand.entity;

import com.shestakam.order.orderItem.entity.OrderItem;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Public class <code>CoffeeBrand</code> is one of entities
 * classes. Its content is fully consistent with Table coffee_brand
 * in database, which we use for. The main role is to store
 * associated with the table information(data).
 */
@Entity
@Table(name = "coffee_brand" ,catalog = "coffeeMarket")
public class CoffeeBrand {

    /**
     * unique identifier of instance
     */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /**
     * parameter describe coffee brand title
     */
    @Column(name = "name",unique = true, nullable = false, length = 20)
    private String name;

    /**
     * parameter describe coffee brand price
     */
    @Column(name = "price",nullable = false)
    private Integer price;

    /**
     * parameter which contains order items for ths coffee brand title
     */
    @JsonIgnore
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoffeeBrand brand = (CoffeeBrand) o;

        if (id != null ? !id.equals(brand.id) : brand.id != null) return false;
        if (name != null ? !name.equals(brand.name) : brand.name != null) return false;
        if (price != null ? !price.equals(brand.price) : brand.price != null) return false;
        return !(orderItemSet != null ? !orderItemSet.equals(brand.orderItemSet) : brand.orderItemSet != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
