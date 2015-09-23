package com.shestakam.order.dao;

import com.shestakam.order.entity.Order;
import com.shestakam.order.orderItem.entity.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by shestakam on 22.9.15.
 */
@Transactional
public class HibernateOrderDao implements OrderDao {

    private final static Logger logger = LogManager.getLogger(HibernateOrderDao.class);
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long save(Order order) {
        logger.debug("add order");
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
        return order.getId();
    }

    @Override
    public Order get(Long id) {
        logger.debug("get order with id : "+id);
        Session session = sessionFactory.getCurrentSession();
        Order order = (Order) session.get(Order.class, id);
        return order;
    }

    @Override
    public List<Order> getAll() {
        logger.debug("get all orders");
        Session session = sessionFactory.getCurrentSession();
        List result = session.createQuery("from com.shestakam.order.entity.Order").list();
        return result;
    }

    @Override
    public void delete(Long id) {
        logger.debug("delete order with id : "+id);
        Session session = sessionFactory.getCurrentSession();
        Order order = (Order) session.get(Order.class, id);
        session.delete(order);
    }

    @Override
    public void update(Order order) {
        logger.debug("update order  with id : " + order.getId());
        Session session = sessionFactory.getCurrentSession();
        session.update(order);
    }

    @Override
    public void saveOrderWithOrderItems(Order order) {
        logger.debug("save order with order items ");
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
        for (OrderItem elem : order.getOrderItemSet()){
            elem.setOrderId(order.getId());
            session.save(elem);
        }

    }
}
