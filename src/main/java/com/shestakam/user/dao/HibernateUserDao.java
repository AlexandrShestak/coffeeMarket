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
 * Created by alexandr on 30.7.15.
 */

@Transactional
public class HibernateUserDao implements UserDao {

    private  final static Logger logger = LogManager.getLogger(HibernateUserDao.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long save(User user) {
        logger.debug("save user");
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user.getId();
    }

    @Override
    public User get(Long id) {
        logger.debug("get user");
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class,id);
        return user;
    }

    @Override
    public List<User> getAll() {
        logger.debug("get all users");
        Session session = sessionFactory.getCurrentSession();
        List result = session.createQuery("from User").list();
        return result;
    }

    @Override
    public void delete(Long id) {
        logger.debug("delete user with username: " + id);
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class,id);
        if (user!=null){
            session.delete(user);
        }
    }

    @Override
    public void update(User user) {
        logger.debug("update user with username: " + user.getUsername());
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public Set<Role> getRoles(String username) {
        logger.debug("get roles  for  : " + username);
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class,username);
        Set<Role> roles = user.getRoleSet();
        return roles;
    }

    @Override
    public void addRole(String username, String roleName) {
        logger.debug("add role  for " + username);
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class,username);
        Role role = (Role) session.createQuery("from Role where role=?")
                .setParameter(0, roleName)
                .list()
                .get(0);
        user.getRoleSet().add(role);
        return ;
    }
}
