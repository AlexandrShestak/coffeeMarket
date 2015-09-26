package com.shestakam.user.authorization;

import com.shestakam.user.dao.UserDao;
import com.shestakam.user.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class RegistrationController {

    private  final static Logger logger = LogManager.getLogger(RegistrationController.class);

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public ResponseEntity<String> registration(@RequestBody User user){
        logger.debug("user registration");
        String login = user.getUsername();
        if(userDao.getUserByName(user.getUsername())!=null){
            logger.debug("user with this username already exists");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }else {
            userDao.save(user);
            userDao.addRole(login,"ROLE_USER");
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
