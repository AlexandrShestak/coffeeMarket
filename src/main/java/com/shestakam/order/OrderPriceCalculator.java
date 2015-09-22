package com.shestakam.order;

import com.shestakam.order.orderItem.entity.OrderItem;

import java.util.List;

/**
 * Created by shestakam on 17.9.15.
 */
public interface OrderPriceCalculator {

    int calculatePrice(List<OrderItem> collection);

}
