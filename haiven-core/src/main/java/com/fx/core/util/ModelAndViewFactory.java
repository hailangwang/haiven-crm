package com.fx.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hlwang on 2017/5/17.
 */
@Component
public class ModelAndViewFactory {

    @Autowired
    private static ModelAndView modelAndView;

    public static ModelAndView createModelAndView(){

        return modelAndView;
    }




}
