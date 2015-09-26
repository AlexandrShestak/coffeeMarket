package com.shestakam.user.dao;

import com.shestakam.db.GenericDao;
import com.shestakam.user.entity.Role;
import com.shestakam.user.entity.User;

import java.util.Set;


public interface UserDao extends GenericDao<User> {
    Set<Role> getRoles(String username);
    void addRole(String username, String role);
    User getUserByName(String name);
}
