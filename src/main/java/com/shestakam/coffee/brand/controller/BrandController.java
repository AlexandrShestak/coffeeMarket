package com.shestakam.coffee.brand.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shestakam.coffee.brand.entity.CoffeeBrand;
import com.shestakam.coffee.brand.service.CoffeeBrandService;
import com.shestakam.order.OrderPriceCalculator;
import com.shestakam.order.orderItem.entity.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by shestakam on 8.9.15.
 */
@RestController
public class BrandController {

    private final static Logger logger = LogManager.getLogger(BrandController.class);
    private CoffeeBrandService coffeeBrandService;


    @Autowired
    private OrderPriceCalculator orderPriceCalculator;

    @Autowired
    public void setCoffeeBrandService(CoffeeBrandService coffeeBrandService) {
        this.coffeeBrandService = coffeeBrandService;
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

    @RequestMapping(value = "/groovy",method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE )
    public int returnGroovyMessage(@RequestBody List<OrderItem> order) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
       /* String jsonString = mapper.writeValueAsString(coffeeBrand.getName()+"tratatat");
        return jsonString;*/
        return orderPriceCalculator.calculatePrice(order);
    }

}
