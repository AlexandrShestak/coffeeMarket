package com.shestakam.order.orderItem.dao;

import com.shestakam.db.GenericDao;
import com.shestakam.order.orderItem.entity.OrderItem;

/**
 * The second level of the hierarchy Data Access layer
 * interfaces. This interface <code>OrderItemDao</code>
 * describes the behavior of a particular dao layer
 * which working with instance of <code>OrderItem</code>.
 */
public interface OrderItemDao extends GenericDao<OrderItem> {
}
