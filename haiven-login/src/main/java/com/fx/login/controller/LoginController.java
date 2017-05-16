package com.fx.login.controller;

import org.springframework.stereotype.Controller;
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

    @ResponseBody
    @RequestMapping(value = "/checkUser")
    public boolean checkUser(){

        return false;
    }


    @RequestMapping(value = "/loginPage")
    public ModelAndView loginPage(String redirectURL) {
        ModelAndView view = new ModelAndView(path + "login");
        view.addObject("redirectURL", redirectURL);
        return view;
    }

}
