package com.shestakam.coffee.brand.dao;

import com.shestakam.coffee.brand.entity.CoffeeBrand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
  hibernate dao class for CoffeeBrand entity
 */
@Repository
@Transactional
public class HibernateCoffeeBrandDao implements CoffeeBrandDao {

    private final static Logger logger = LogManager.getLogger(HibernateCoffeeBrandDao.class);
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * save coffeeBrand entity in database
     * @param coffeeBrand entity which will be save
     * @return id of new entity
     */
    public Long save(CoffeeBrand coffeeBrand) {
        logger.debug("add coffee brand");
        Session session = sessionFactory.getCurrentSession();
        session.save(coffeeBrand);
        return coffeeBrand.getId();
    }

    /**
     * get coffeeBrand entity from database
     * @param id of entity which will be load
     * @return loaded CoffeeBrand entity
     */
    public CoffeeBrand get(Long id) {
        logger.debug("get coffee brand with id : "+id);
        Session session = sessionFactory.getCurrentSession();
        CoffeeBrand brand = (CoffeeBrand) session.get(CoffeeBrand.class, id);
        return brand;
    }

    /**
     * method to load all coffee  brands entities from database
     * @return all coffee  brands entities from database
     */
    public List<CoffeeBrand> getAll() {
        logger.debug("get all coffee brands");
        Session session = sessionFactory.getCurrentSession();
        List result = session.createQuery("from com.shestakam.coffee.brand.entity.CoffeeBrand").list();
        return result;
    }

    /**
     * delete coffeeBrand entity by id
     * @param id of entity which will be deleted
     */
    public void delete(Long id) {
        logger.debug("delete coffee brand with id : "+id);
        Session session = sessionFactory.getCurrentSession();
        CoffeeBrand brand = (CoffeeBrand) session.get(CoffeeBrand.class, id);
        session.delete(brand);
    }


    /**
     * update existing coffeeBrand entity in database
     * @param coffeeBrand updated entity which will replace existing entity with same id
     */
    public void update(CoffeeBrand coffeeBrand) {
        logger.debug("update coffee brand with id : " +coffeeBrand.getId());
        Session session = sessionFactory.getCurrentSession();
        session.update(coffeeBrand);
    }
}
