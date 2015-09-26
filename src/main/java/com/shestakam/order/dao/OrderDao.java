package com.shestakam.order.dao;

import com.shestakam.db.GenericDao;
import com.shestakam.order.entity.Order;

/**
 * The second level of the hierarchy Data Access layer
 * interfaces. This interface <code>OrderDao</code>
 * describes the behavior of a particular dao layer
 * which working with instance of <code>Order</code>.
 */
public interface OrderDao extends GenericDao<Order> {
    void saveOrderWithOrderItems(Order order);
}
