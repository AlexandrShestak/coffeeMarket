package com.shestakam.coffee.brand.service;

import com.shestakam.coffee.brand.dao.CoffeeBrandDao;
import com.shestakam.coffee.brand.entity.CoffeeBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shestakam on 8.9.15.
 */
@Service
public class CoffeeBrandServiceImpl implements CoffeeBrandService {

    private CoffeeBrandDao coffeeBrandDao;

    @Autowired
    public void setCoffeeBrandDao(CoffeeBrandDao coffeeBrandDao) {
        this.coffeeBrandDao = coffeeBrandDao;
    }

    public Long save(CoffeeBrand coffeeBrand) {
        return coffeeBrandDao.save(coffeeBrand);
    }

    public CoffeeBrand get(Long id) {
        return coffeeBrandDao.get(id);
    }

    public List<CoffeeBrand> getAll() {
        return coffeeBrandDao.getAll();
    }

    public void delete(Long id) {
        coffeeBrandDao.delete(id);
    }

    public void update(CoffeeBrand coffeeBrand) {
        coffeeBrandDao.update(coffeeBrand);
    }
}
