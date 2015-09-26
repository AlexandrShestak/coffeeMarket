package com.shestakam.coffee.brand.dao;

import com.shestakam.coffee.brand.entity.CoffeeBrand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.shestakam.db.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 jdbc dao class for CoffeeBrand entity
 */
public class JdbcCoffeeBrandDao implements CoffeeBrandDao {

    private final static Logger logger = LogManager.getLogger(JdbcCoffeeBrandDao.class);

    /**
     * save coffeeBrand entity in database
     * @param coffeeBrand entity which will be save
     * @return id of new entity
     */
    @Override
    public Long save(CoffeeBrand coffeeBrand) {
        int key = 0;
        try(Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into coffee_brand (name, price)  VALUES (?,?)",
                            Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, coffeeBrand.getName());
            preparedStatement.setInt(2, coffeeBrand.getPrice());
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            keys.next();
            key = keys.getInt(1);
            logger.error("save coffee brand ");
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("save  coffee brand error ", e);
        }
        return Long.valueOf(key);
    }

    /**
     * get coffeeBrand entity from database
     * @param id of entity which will be load
     * @return loaded CoffeeBrand entity
     */
    @Override
    public CoffeeBrand get(Long id) {
        CoffeeBrand brand = new CoffeeBrand();
        try(Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from coffee_brand where id=?")) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                brand.setName(rs.getString("name"));
                brand.setPrice(rs.getInt("price"));
                brand.setId(rs.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("get coffee brand error", e);
        }
        logger.debug("get coffee brand with id : " + brand.getId());
        return brand;
    }

    /**
     * method to load all coffee  brands entities from database
     * @return all coffee  brand entities from database
     */
    @Override
    public List<CoffeeBrand> getAll() {
        List<CoffeeBrand> brandList = new ArrayList<>();
        try (Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery("select * from coffee_brand");
            while (rs.next()) {
                CoffeeBrand brand = new CoffeeBrand();
                brand.setName(rs.getString("name"));
                brand.setPrice(rs.getInt("price"));
                brand.setId(rs.getLong("id"));
                brandList.add(brand);
            }
            logger.debug("get all coffee brands");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("get all coffee brands error",e);
        }
        return brandList;
    }

    /**
     * delete coffeeBrand entity by id
     * @param id of entity which will be deleted
     */
    @Override
    public void delete(Long id) {
        try(Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("delete from coffee_brand where id=?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            logger.debug("delete coffee brand with id: "+ id);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("delete coffee brand error",e);
        }
    }

    /**
     * update existing coffeeBrand entity in database
     * @param coffeeBrand updated entity which will replace existing entity with same id
     */
    @Override
    public void update(CoffeeBrand coffeeBrand) {
        try(Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update coffee_brand set name=?,price=? where id=?")){
            preparedStatement.setString(1, coffeeBrand.getName());
            preparedStatement.setInt(2, coffeeBrand.getPrice());
            preparedStatement.setLong(3, coffeeBrand.getId());
            preparedStatement.executeUpdate();
            logger.debug("edit coffee brand with id :" + coffeeBrand.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("edit coffee brand error",e);
        }
    }
}
