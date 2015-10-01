package com.shestakam.user.dao;

import com.shestakam.user.entity.Role;
import com.shestakam.user.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 hibernate dao class for User entity
 */
@Transactional
public class HibernateUserDao implements UserDao {

    private  final static Logger logger = LogManager.getLogger(HibernateUserDao.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * save user entity in database
     * @param user entity which will be save
     * @return id of new entity
     */
    @Override
    public Long save(User user) {
        logger.debug("save user");
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user.getId();
    }
    /**
     * get user entity from database
     * @param id of entity which will be load
     * @return loaded user entity
     */
    @Override
    public User get(Long id) {
        logger.debug("get user");
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class,id);
        return user;
    }

    /**
     * method to load all user entities from database
     * @return all user entities from database
     */
    @Override
    public List<User> getAll() {
        logger.debug("get all users");
        Session session = sessionFactory.getCurrentSession();
        List result = session.createQuery("from User").list();
        return result;
    }

    /**
     * delete user entity by id
     * @param id of entity which will be deleted
     */
    @Override
    public void delete(Long id) {
        logger.debug("delete user with username: " + id);
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class,id);
        if (user!=null){
            session.delete(user);
        }
    }

    /**
     * update existing user entity in database
     * @param user updated entity which will replace existing entity with same id
     */
    @Override
    public void update(User user) {
        logger.debug("update user with username: " + user.getUsername());
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    /**
     * return roles for current user which used in spring security
     * @param username name of user
     * @return roles for user
     */
    @Override
    public Set<Role> getRoles(String username) {
        logger.debug("get roles  for  : " + username);
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.createQuery("from User where username=?")
                .setParameter(0,username)
                .list()
                .get(0);
        Set<Role> roles = user.getRoleSet();
        return roles;
    }

    /**
     * add role for user
     * @param username  name of user
     * @param role role name
     */
    @Override
    public void addRole(String username, String roleName) {
        logger.debug("add role  for " + username);
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.createQuery("from User where username=?")
                .setParameter(0,username)
                .list()
                .get(0);
        Role role = (Role) session.createQuery("from Role where role=?")
                .setParameter(0, roleName)
                .list()
                .get(0);
        user.getRoleSet().add(role);
        session.update(user);
        return ;
    }

    /**
     * return user entity by name
     * @param name name of user entity
     * @return user entity
     */
    @Override
    public User getUserByName(String name) {
        logger.debug("get user by name");
        Session session = sessionFactory.getCurrentSession();
        List<User> users =  session.createQuery("from User where username=?")
                .setParameter(0,name)
                .list();
        if (users.size() == 0){
            return null;
        }
        return users.get(0);
    }
}
