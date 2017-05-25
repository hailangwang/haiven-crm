package com.fx.login.service.impl;

import com.alibaba.fastjson.JSON;
import com.fx.core.util.ContantUtil;
import com.fx.login.dao.UserMapper;
import com.fx.login.entity.UserEntity;
import com.fx.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

/**
 * Created by hlwang on 2017/5/17.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

   @Autowired
    private UserMapper userMapper;

    public String checkUser(UserEntity userEntity) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("status",ContantUtil.FAIL);
        UserEntity findUserEntity = userMapper.getUser(userEntity);
        if(findUserEntity!=null){
            modelAndView.addObject("status", ContantUtil.SUCCESS);
        }else{
              modelAndView.addObject("message","用户名或者密码不正确！");
        }
        return JSON.toJSONString(modelAndView);
    }
}
