package com.shestakam.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
