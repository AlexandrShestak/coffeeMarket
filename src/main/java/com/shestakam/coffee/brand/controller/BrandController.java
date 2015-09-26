package com.shestakam.coffee.brand.controller;

import com.shestakam.coffee.brand.dao.CoffeeBrandDao;
import com.shestakam.coffee.brand.entity.CoffeeBrand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by shestakam on 8.9.15.
 */
@RestController
public class BrandController {

    private final static Logger logger = LogManager.getLogger(BrandController.class);

    private CoffeeBrandDao coffeeBrandDao;

    @Autowired
    @Qualifier("jdbcCoffeeBrandDao")
    public void setCoffeeBrandDao(CoffeeBrandDao coffeeBrandDao) {
        this.coffeeBrandDao = coffeeBrandDao;
    }


    @RequestMapping(value = "/brands",method = RequestMethod.GET)
    public List<CoffeeBrand> getAllBrands() {
        logger.debug("get all brands");
        return coffeeBrandDao.getAll();
    }


}
