package com.shestakam.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shestakam.coffee.brand.controller.PriceCount;
import com.shestakam.coffee.brand.dao.CoffeeBrandDao;
import com.shestakam.coffee.brand.entity.CoffeeBrand;
import com.shestakam.order.OrderPriceCalculator;
import com.shestakam.order.dao.OrderDao;
import com.shestakam.order.entity.Order;
import com.shestakam.order.orderItem.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shestakam on 26.9.15.
 */
@RestController
public class OrderController {

    private final static Logger logger = LogManager.getLogger(OrderController.class);

    private OrderDao orderDao;
    private CoffeeBrandDao coffeeBrandDao;

    @Autowired
    private OrderPriceCalculator orderPriceCalculator;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }


    public void setCoffeeBrandDao(CoffeeBrandDao coffeeBrandDao) {
        this.coffeeBrandDao = coffeeBrandDao;
    }

    @RequestMapping(value = "/calculatePrice",method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE )
    public int calculateOrderPride(@RequestBody List<OrderItem> order) throws JsonProcessingException {
        logger.debug("get all brands");
        List<PriceCount> priceCountList = new ArrayList<>();
        for (OrderItem elem : order){
            PriceCount priceCount = new PriceCount();
            CoffeeBrand brand = coffeeBrandDao.get(elem.getBrandId());
            priceCount.setPrice(brand.getPrice());
            priceCount.setCount(elem.getAmount());
            priceCountList.add(priceCount);
        }
        return orderPriceCalculator.calculatePrice(priceCountList);
    }

    @RequestMapping(value = "/makeOrder",method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE )
    public void makeOrder(@RequestBody Order order) throws JsonProcessingException {
        orderDao.saveOrderWithOrderItems(order);
        return ;
    }
}
