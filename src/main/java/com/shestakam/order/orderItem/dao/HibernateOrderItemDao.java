package com.shestakam.order.orderItem.dao;

import com.shestakam.order.orderItem.entity.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by shestakam on 22.9.15.
 */
public class HibernateOrderItemDao implements OrderItemDao {

    private final static Logger logger = LogManager.getLogger(HibernateOrderItemDao.class);
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long save(OrderItem orderItem) {
        return null;
    }

    @Override
    public OrderItem get(Long id) {
        return null;
    }

    @Override
    public List<OrderItem> getAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(OrderItem orderItem) {

    }
}
