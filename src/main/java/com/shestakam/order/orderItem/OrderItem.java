package com.shestakam.order.orderItem;

/**
 * Created by shestakam on 20.9.15.
 */
public class OrderItem {
    private Long id;
    private String brand;
    private  int price;
    private int count;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return brand;
    }

    public void setName(String name) {
        this.brand = name;
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