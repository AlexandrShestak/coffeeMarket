package com.shestakam.coffee.brand.dao;

import com.shestakam.coffee.brand.entity.CoffeeBrand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shestakam on 8.9.15.
 */
@Repository
public class HibernateCoffeeBrandDao implements CoffeeBrandDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long save(CoffeeBrand coffeeBrand) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(coffeeBrand);
        session.getTransaction().commit();
        return coffeeBrand.getId();
    }

    public CoffeeBrand get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CoffeeBrand brand = (CoffeeBrand) session.get(CoffeeBrand.class, id);
        session.getTransaction().commit();
        return brand;
    }

    public List<CoffeeBrand> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from com.shestakam.coffee.brand.entity.CoffeeBrand").list();
        session.getTransaction().commit();
        return result;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CoffeeBrand brand = (CoffeeBrand) session.get(CoffeeBrand.class, id);
        session.delete(brand);
        session.getTransaction().commit();
    }

    public void update(CoffeeBrand coffeeBrand) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(coffeeBrand);
        session.getTransaction().commit();

    }
}
