package com.shestakam.user.authorization;

import com.shestakam.user.dao.UserDao;
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
    private static final String LOGIN_PAGE = "login";

    private UserDao userDao;


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @RequestMapping("/user")
    @ResponseBody
    public Principal user(Principal user){
        return user;
    }




    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
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
