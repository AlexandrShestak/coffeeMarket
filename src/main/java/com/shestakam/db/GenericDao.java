package com.shestakam.db;

import java.util.List;

/**
 * Generic interface GenericDao
 * The top of the inheritance hierarchy of
 * interfaces Data Access layer contains a set
 * of four standard operations for working with
 * data base common to all DAO implementations.
 *
 * @param <Entity> the type of elements in this interface
 */
public interface GenericDao<Entity> {
     /**
      * Public abstract method which defining the operation
      * of adding record in a database.
      *
      * @param entity record to be added
      * @return inserted entityID
      */
     Long save(Entity entity);

     /**
      * Public abstract method which one defining the operation
      * of reading record in a database.
      *
      * @param id unique identifier of a record to read
      * @return entity record to be read
      */
     Entity get(Long id);

     /**
      * Public abstract method which one defining the operation
      * of reading all records in a database.
      *
      * @return list of entity records to read
      */
     List<Entity> getAll();

     /**
      * Public abstract method which one defining the operation
      * of deleting record from a database.
      *
      * @param id unique identifier of a record to deleted
      * @see java.sql.SQLException
      */
     void delete(Long id);


     /**
      * Public abstract method which one defining the operation
      * of updating record in a database.
      *
      * @param entity record to updated
      */
     void update(Entity entity);
}

