package com.shestakam.order.dao;

import com.shestakam.order.entity.Order;

import com.shestakam.coffee.brand.entity.CoffeeBrand;
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
 * Created by shestakam on 24.9.15.
 */
@Repository
public class JdbcOrderDao implements OrderDao {

    private final static Logger logger = LogManager.getLogger(JdbcOrderDao.class);

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

    @Override
    public void saveOrderWithOrderItems(Order order) {
        int key = 0;
        try(Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into user_order (address, total_price, username)" +
                                    "values (null, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            PreparedStatement psToAddItems =
                    connection.prepareStatement("insert into order_item (amount, brand_id, order_id) " +
                            "values (null, ?, ?, ?)")) {
            preparedStatement.setString(1, order.getUsername());
            preparedStatement.setString(2, order.getAddress());
            preparedStatement.setInt(3,order.getTotalPrice());
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            keys.next();
            key = keys.getInt(1);
            for (OrderItem elem : order.getOrderItemSet()){
                elem.setOrderId(order.getId());
                psToAddItems.setInt(1, elem.getCount());
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
