package com.shestakam.user.authorization;

import com.shestakam.user.dao.UserDao;
import com.shestakam.user.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


@Controller
public class AuthorizationController {

    private  final static Logger logger = LogManager.getLogger(AuthorizationController.class);

    private UserDao userDao;


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @RequestMapping("/user")
    @ResponseBody
    public void user(Principal user){
        return ;
    }




    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String login(Principal user) {
        logger.debug("login");

      /*  User userInDatabase = userDao.getUserByName(user.getName());
        if ( userInDatabase == null){
            String messs
        }*/
/*
        logger.debug("login");
        ModelAndView model = new ModelAndView();
        if (error != null) {
            logger.debug("Invalid username and password!");
            model.addObject("errorMessage", "Invalid username and password!");
        }
        if (logout != null) {
            logger.debug("You've been logged out successfully.");
            model.addObject("logoutMessage", "You've been logged out successfully.");
        }
        model.setViewName(LOGIN_PAGE);
        logger.debug("successfully login");*/
        return "coffee";
    }
}
