package com.shestakam.order.controller;

/**
 *  helper class which contains two fields price and count
 *  to save this information in collection
 */
public class PriceCount {
    private int price;
    private int count;

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
