package com.shestakam.coffee.controller;

import com.shestakam.order.entity.OrderPriceCalcilator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shestakam on 1.9.15.
 */
@Controller
public class CoffeeController {

    @Autowired
    private OrderPriceCalcilator orderPriceCalcilator;

    @RequestMapping(value = "/coffee")
    public String returnPage(){
        return "coffee";
    }


    @RequestMapping(value = "/groovy")
    @ResponseBody
    public String returnGroovyMessage(){
        return orderPriceCalcilator.getMessage();
    }

}
