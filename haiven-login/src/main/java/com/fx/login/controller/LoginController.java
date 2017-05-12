package com.fx.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hlwang on 2017/5/11.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {



    @ResponseBody
    @RequestMapping(value = "/login")
    public boolean checkUser(){
        System.out.println(111);

        return false;
    }

}
