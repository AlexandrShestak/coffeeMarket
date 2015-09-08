package com.shestakam.db;

import java.util.List;

/**
 * Created by shestakam on 8.9.15.
 */
public interface GenericService<Entity> {
    Long save(Entity entity);
    Entity get(Long id);
    List<Entity> getAll();
    void delete(Long id);
    void update(Entity entity);
}
