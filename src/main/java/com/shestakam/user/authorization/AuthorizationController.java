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


    @RequestMapping(value = "/login" )
    @ResponseBody
    public void login(Principal user) {
        return;
    }
}
