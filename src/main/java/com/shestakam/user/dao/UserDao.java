package com.shestakam.user.dao;

import com.shestakam.db.GenericDao;
import com.shestakam.user.entity.Role;
import com.shestakam.user.entity.User;

import java.util.Set;


/**
 * The second level of the hierarchy Data Access layer
 * interfaces. This interface <code>UserDao</code>
 * describes the behavior of a particular dao layer
 * which working with instance of <code>User/code>.
 */
public interface UserDao extends GenericDao<User> {

    /**
     * return roles for current user which used in spring security
     * @param username name of user
     * @return roles for user
     */
    Set<Role> getRoles(String username);

    /**
     * add role for user
     * @param username  name of user
     * @param role role name
     */
    void addRole(String username, String role);

    /**
     * return user entity by name
     * @param name name of user entity
     * @return user entity
     */
    User getUserByName(String name);
}
