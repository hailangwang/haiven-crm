package com.fx.login.service;

import com.fx.login.entity.UserEntity;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hlwang on 2017/5/17.
 */
public interface UserService {

    public String checkUser(UserEntity userEntity);



}
