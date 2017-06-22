package com.fx.login.controller;

import com.fx.core.redis.RedisCacheStorage;
import com.fx.core.redis.cluster.RedisClusterFactory;
import com.fx.login.entity.UserEntity;
import com.fx.login.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by hlwang on 2017/5/11.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private final String path = "/login/";

    private static  final Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

   @Autowired
    private RedisClusterFactory redisClusterFactory;

    @Autowired
    private  RedisTemplate redisTemplate;

    @ResponseBody
    @RequestMapping(value = "/checkUser")
    public String checkUser(@RequestBody UserEntity userEntity){


//        redisTemplate.opsForValue().set("wang","wang");
//        redisTemplate.opsForValue().set("hai", "hai");
//        redisTemplate.opsForValue().set("lang","lang");
//        System.out.println( redisTemplate.opsForValue().get("wang"));

//        redisClusterFactory.getObject()

      logger.info("111");
        return userService.checkUser(userEntity);

    }



    @RequestMapping(value = "/loginPage")
    public ModelAndView loginPage(String redirectURL) {
        ModelAndView view = new ModelAndView(path + "login");
        view.addObject("redirectURL", redirectURL);
        return view;
    }


}
