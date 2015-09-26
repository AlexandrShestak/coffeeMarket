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
 hibernate dao class for Order entity
 */
@Transactional
public class HibernateOrderDao implements OrderDao {

    private final static Logger logger = LogManager.getLogger(HibernateOrderDao.class);
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    /**
     * save order entity in database
     * @param order entity which will be save
     * @return id of new entity
     */
    @Override
    public Long save(Order order) {
        logger.debug("add order");
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
        return order.getId();
    }

    /**
     * get order entity from database
     * @param id  of entity which will be load
     * @return loaded order entity
     */
    @Override
    public Order get(Long id) {
        logger.debug("get order with id : "+id);
        Session session = sessionFactory.getCurrentSession();
        Order order = (Order) session.get(Order.class, id);
        return order;
    }

    /**
     * method to load all order entities from database
     * @return all order entities from database
     */
    @Override
    public List<Order> getAll() {
        logger.debug("get all orders");
        Session session = sessionFactory.getCurrentSession();
        List result = session.createQuery("from com.shestakam.order.entity.Order").list();
        return result;
    }

    /**
     * delete order entity by id
     * @param id of entity which will be deleted
     */
    @Override
    public void delete(Long id) {
        logger.debug("delete order with id : "+id);
        Session session = sessionFactory.getCurrentSession();
        Order order = (Order) session.get(Order.class, id);
        session.delete(order);
    }

    /**
     * update existing order entity in database
     * @param order updated entity which will replace existing entity with same id
     */
    @Override
    public void update(Order order) {
        logger.debug("update order  with id : " + order.getId());
        Session session = sessionFactory.getCurrentSession();
        session.update(order);
    }

    /**
     * save order with order items
     * @param order entity with order items @see com.shestakam.order.orderItem.entity.OrderItem which will be save
     */
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
