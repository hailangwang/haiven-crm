package com.fx.login.controller;

import com.fx.login.entity.UserEntity;
import com.fx.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hlwang on 2017/5/11.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private final String path = "/login/";

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/checkUser")
    public String checkUser(@RequestBody UserEntity userEntity){
        return userService.checkUser(userEntity);

    }



    @RequestMapping(value = "/loginPage")
    public ModelAndView loginPage(String redirectURL) {
        ModelAndView view = new ModelAndView(path + "login");
        view.addObject("redirectURL", redirectURL);
        return view;
    }


}
