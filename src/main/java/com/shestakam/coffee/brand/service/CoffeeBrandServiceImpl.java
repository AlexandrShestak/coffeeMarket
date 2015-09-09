package com.shestakam.coffee.brand.service;

import com.shestakam.coffee.brand.dao.CoffeeBrandDao;
import com.shestakam.coffee.brand.entity.CoffeeBrand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by shestakam on 8.9.15.
 */
@Service
@Transactional
public class CoffeeBrandServiceImpl implements CoffeeBrandService {

    private final static Logger logger = LogManager.getLogger(CoffeeBrandServiceImpl.class);

    private CoffeeBrandDao coffeeBrandDao;

    @Autowired
    public void setCoffeeBrandDao(CoffeeBrandDao coffeeBrandDao) {
        this.coffeeBrandDao = coffeeBrandDao;
    }

    public Long save(CoffeeBrand coffeeBrand) {
        logger.debug("add coffee brand");
        return coffeeBrandDao.save(coffeeBrand);
    }

    public CoffeeBrand get(Long id) {
        logger.debug("get coffee brand with id : "+id);
        return coffeeBrandDao.get(id);
    }

    public List<CoffeeBrand> getAll() {
        logger.debug("get all coffee brands");
        return coffeeBrandDao.getAll();
    }

    public void delete(Long id) {
        logger.debug("delete coffee brand with id : "+id);
        coffeeBrandDao.delete(id);
    }

    public void update(CoffeeBrand coffeeBrand) {
        logger.debug("update coffee brand with id : " +coffeeBrand.getId());
        coffeeBrandDao.update(coffeeBrand);
    }
}
