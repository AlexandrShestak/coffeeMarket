package com.shestakam.coffee.brand.dao;

import com.shestakam.coffee.brand.entity.CoffeeBrand;
import com.shestakam.db.GenericDao;

/**
 * The second level of the hierarchy Data Access layer
 * interfaces. This interface <code>CoffeeBrandDao</code>
 * describes the behavior of a particular dao layer
 * which working with instance of <code>CoffeeBrand</code>.
 */
public interface CoffeeBrandDao extends GenericDao<CoffeeBrand> {
}
