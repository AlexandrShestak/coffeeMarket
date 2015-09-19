package com.shestakam.coffee.controller;

import com.shestakam.order.entity.OrderPriceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by shestakam on 1.9.15.
 */
@Controller
public class CoffeeController {

    @RequestMapping(value = "/coffee")
    public String returnPage(){
        return "coffee";
    }






}
