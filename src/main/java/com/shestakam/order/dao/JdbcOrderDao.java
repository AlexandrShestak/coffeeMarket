package com.shestakam.order.dao;

import com.shestakam.order.entity.Order;

import com.shestakam.order.orderItem.entity.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.shestakam.db.JdbcConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 jdbc dao class for order entity
 */
@Repository
public class JdbcOrderDao implements OrderDao {

    private final static Logger logger = LogManager.getLogger(JdbcOrderDao.class);


    /**
     * save order entity in database
     * @param order entity which will be save
     * @return id of new entity
     */
    @Override
    public Long save(Order order) {
        int key = 0;
        try(Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into user_order (username, address, total_price)   " +
                                    "VALUES (?,?,?)",
                            Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, order.getUsername());
            preparedStatement.setString(2, order.getAddress());
            preparedStatement.setInt(3,order.getTotalPrice());
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            keys.next();
            key = keys.getInt(1);
            logger.error("save order");
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("save  order error ", e);
        }
        return Long.valueOf(key);
    }

    /**
     * get order entity from database
     * @param id of entity which will be load
     * @return loaded order entity
     */
    @Override
    public Order get(Long id) {
       Order order = new Order();
        try(Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from user_order where id=?")) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                order.setId(rs.getLong("id"));
                order.setAddress(rs.getString("address"));
                order.setTotalPrice(rs.getInt("total_price"));
                order.setUsername(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("get order error", e);
        }
        logger.debug("get order with id : " + order.getId());
        return order;
    }

    /**
     * method to load all order entities from database
     * @return all order entities from database
     */
    @Override
    public List<Order> getAll() {
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery("select * from user_order");
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getLong("id"));
                order.setAddress(rs.getString("address"));
                order.setTotalPrice(rs.getInt("total_price"));
                order.setUsername(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("get all orders error",e);
        }
        logger.debug("get all orders");
        return orderList;
    }

    /**
     * delete order entity by id
     * @param id of entity which will be deleted
     */
    @Override
    public void delete(Long id) {
        try(Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("delete from user_order where id=?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            logger.debug("delete order with id: "+ id);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("delete order error",e);
        }
    }

    /**
     * update existing order entity in database
     * @param order updated entity which will replace existing entity with same id
     */
    @Override
    public void update(Order order) {
        try(Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update user_order set" +
                            " username=?,address=?,total_price=? where id=?")){
            preparedStatement.setString(1, order.getUsername());
            preparedStatement.setString(2, order.getAddress());
            preparedStatement.setInt(3, order.getTotalPrice());
            preparedStatement.executeUpdate();
            logger.debug("edit order with id :" + order.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("edit order error",e);
        }
    }

    /**
     * save order with order items
     * @param order entity with order items @see com.shestakam.order.orderItem.entity.OrderItem which will be save
     */
    @Override
    public void saveOrderWithOrderItems(Order order) {
        int key = 0;
        try(Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into user_order (address, total_price, username)" +
                                    "values (?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            PreparedStatement psToAddItems =
                    connection.prepareStatement("insert into order_item (amount, brand_id, order_id) " +
                            "values (?, ?, ?)")) {
            preparedStatement.setString(1, order.getUsername());
            preparedStatement.setString(2, order.getAddress());
            preparedStatement.setInt(3,order.getTotalPrice());
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            keys.next();
            key = keys.getInt(1);
            for (OrderItem elem : order.getOrderItemSet()){
                elem.setOrderId(order.getId());
                psToAddItems.setInt(1, elem.getAmount());
                psToAddItems.setLong(2, elem.getBrandId());
                psToAddItems.setLong(3, key);
                psToAddItems.executeUpdate();
            }

            logger.error("save order with order items");
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("save  order with order items ", e);
        }
    }
}
