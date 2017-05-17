package com.fx.login.service.impl;

import com.fx.core.util.ContantUtil;
import com.fx.core.util.ModelAndViewFactory;
import com.fx.login.dao.UserDao;
import com.fx.login.entity.UserEntity;
import com.fx.login.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hlwang on 2017/5/17.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao;


    public ModelAndView checkUser(UserEntity userEntity) {


       ModelAndView modelAndView = ModelAndViewFactory.createModelAndView();
       modelAndView.addObject("stauts", ContantUtil.SUCCESS);

        ModelAndView modelAndView2 = ModelAndViewFactory.createModelAndView();


        UserEntity findUserEntity = userDao.getUser(userEntity);
        if(findUserEntity!=null){

        }

        return null;
    }
}
