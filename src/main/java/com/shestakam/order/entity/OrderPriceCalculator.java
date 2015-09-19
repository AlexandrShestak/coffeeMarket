package com.shestakam.order.entity;

import java.util.Collection;

/**
 * Created by shestakam on 17.9.15.
 */
public interface OrderPriceCalculator {

    int calculatePrice(Collection collection);

}
