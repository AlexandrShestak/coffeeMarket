package com.shestakam.coffee.brand.controller;

import com.shestakam.coffee.brand.entity.CoffeeBrand;
import com.shestakam.coffee.brand.service.CoffeeBrandService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by shestakam on 8.9.15.
 */
@RestController
public class BrandController {

    private final static Logger logger = LogManager.getLogger(BrandController.class);
    private CoffeeBrandService coffeeBrandService;

    @Autowired
    public void setCoffeeBrandService(CoffeeBrandService coffeeBrandService) {
        this.coffeeBrandService = coffeeBrandService;
    }

    public List<CoffeeBrand> getAllBrands() {
        logger.debug("get all brands");

        return coffeeBrandService.getAll();
    }
}
