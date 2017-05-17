package com.fx.login.interceptor;

import org.apache.ibatis.plugin.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by hlwang on 2017/5/8.
 */
public class LoginInterceptor implements HandlerInterceptor {

    private List<String> ignoreURL;


    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        Boolean flag =false;

        if(ignoreURL!=null && ignoreURL.size()>0){
           String url = httpServletRequest.getRequestURI();
            System.out.println( httpServletRequest.getRequestURI());
            System.out.println(httpServletRequest.getServletPath().toString());


            if(ignoreURL.contains(url)){
                flag = true;
            }
        }
        if(flag){
            return true;
        }else {
            String contextPath=httpServletRequest.getContextPath();
            String  uri=httpServletRequest.getServletPath().toString();
//            httpServletResponse.sendRedirect(contextPath+"/login/loginPage");
            httpServletResponse.sendRedirect(contextPath+"/login/loginPage?redirectURL="
                    + URLEncoder.encode(uri));
            return  false;
        }

    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {



    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
