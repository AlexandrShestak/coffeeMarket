package com.shestakam.order.orderItem.dao;

import com.shestakam.order.orderItem.entity.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 hibernate dao class for OrderItem entity
 */
@Transactional
public class HibernateOrderItemDao implements OrderItemDao {

    private final static Logger logger = LogManager.getLogger(HibernateOrderItemDao.class);
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    /**
     * save OrderItem entity in database
     * @param orderItem entity which will be save
     * @return id of new entity
     */
    @Override
    public Long save(OrderItem orderItem) {
        logger.debug("add order item");
        Session session = sessionFactory.getCurrentSession();
        session.save(orderItem);
        return orderItem.getId();
    }

    /**
     * get OrderItem entity from database
     * @param id  of entity which will be load
     * @return loaded OrderItem entity
     */
    @Override
    public OrderItem get(Long id) {
        logger.debug("get order item with id : "+id);
        Session session = sessionFactory.getCurrentSession();
        OrderItem orderItem = (OrderItem) session.get(OrderItem.class, id);
        return orderItem;
    }

    /**
     * method to load all OrderItem entities from database
     * @return all OrderItem entities from database
     */
    @Override
    public List<OrderItem> getAll() {
        logger.debug("get all order items");
        Session session = sessionFactory.getCurrentSession();
        List result = session.createQuery("from com.shestakam.order.orderItem.entity.OrderItem").list();
        return result;
    }

    /**
     * delete OrderItem entity by id
     * @param id of entity which will be deleted
     */
    @Override
    public void delete(Long id) {
        logger.debug("delete order item with id : "+id);
        Session session = sessionFactory.getCurrentSession();
        OrderItem orderItem = (OrderItem) session.get(OrderItem.class, id);
        session.delete(orderItem);
    }

    /**
     * update existing OrderItem entity in database
     * @param orderItem updated entity which will replace existing entity with same id
     */
    @Override
    public void update(OrderItem orderItem) {
        logger.debug("update order item with id : " + orderItem.getId());
        Session session = sessionFactory.getCurrentSession();
        session.update(orderItem);
    }
}
