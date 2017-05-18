package com.fx.login.service.impl;

import com.fx.core.util.ContantUtil;
import com.fx.core.util.ModelAndViewFactory;
import com.fx.login.dao.UserDao;
import com.fx.login.entity.UserEntity;
import com.fx.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hlwang on 2017/5/17.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

   @Autowired
    private UserDao userDao;


    public ModelAndView checkUser(UserEntity userEntity) {
//        String findUserEntity = userDao.getUser(userEntity);
        UserEntity findUserEntity = userDao.getUser(userEntity);
        if(findUserEntity!=null){

        }

        return null;
    }
}
