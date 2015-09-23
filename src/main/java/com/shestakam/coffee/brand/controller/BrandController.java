package com.shestakam.coffee.brand.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shestakam.coffee.brand.entity.CoffeeBrand;
import com.shestakam.coffee.brand.service.CoffeeBrandService;
import com.shestakam.order.OrderPriceCalculator;
import com.shestakam.order.dao.OrderDao;
import com.shestakam.order.entity.Order;
import com.shestakam.order.orderItem.entity.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shestakam on 8.9.15.
 */
@RestController
public class BrandController {

    private final static Logger logger = LogManager.getLogger(BrandController.class);

    private CoffeeBrandService coffeeBrandService;
    private OrderDao orderDao;


    @Autowired
    private OrderPriceCalculator orderPriceCalculator;

    @Autowired
    public void setCoffeeBrandService(CoffeeBrandService coffeeBrandService) {
        this.coffeeBrandService = coffeeBrandService;
    }

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @RequestMapping(value = "/brands",method = RequestMethod.GET)
    public List<CoffeeBrand> getAllBrands() {
        logger.debug("get all brands");

        return coffeeBrandService.getAll();
    }

  /*  @RequestMapping(value = "/groovy",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String returnGroovyMessage(@ModelAttribute String str){
        return "tratatat";
        //return orderPriceCalcilator.calculatePrice(collection);
    }*/

    @RequestMapping(value = "/calculatePrice",method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE )
    public int returnGroovyMessage(@RequestBody List<OrderItem> order) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

       /* String jsonString = mapper.writeValueAsString(coffeeBrand.getName()+"tratatat");
        return jsonString;*/
        List<PriceCount> priceCountList = new ArrayList<>();
        for (OrderItem elem : order){
            PriceCount priceCount = new PriceCount();
            CoffeeBrand brand = coffeeBrandService.get(elem.getBrandId());
            priceCount.setPrice(brand.getPrice());
            priceCount.setCount(elem.getCount());
            priceCountList.add(priceCount);
        }
        return orderPriceCalculator.calculatePrice(priceCountList);
    }

    @RequestMapping(value = "/makeOrder",method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE )
    public int makeOrder(@RequestBody Order order) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        orderDao.saveOrderWithOrderItems(order);

        return 12;
    }



}
