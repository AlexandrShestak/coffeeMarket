package com.shestakam.coffee.brand.entity;

import javax.persistence.*;

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
}
