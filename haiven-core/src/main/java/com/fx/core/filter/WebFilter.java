package com.fx.core.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by hlwang on 2017/5/8.
 */
public class WebFilter implements Filter {

    private String[] ignoreType;

    private boolean isIgnoreType;

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        String url = httpServletRequest.getContextPath();
        if(ignoreType!=null && ignoreType.length>0){
            for(int i=0;i<ignoreType.length;i++){
                if(url.endsWith("."+ignoreType[i])){
                    isIgnoreType =true;
                    break;
                }
            }
        }
        if(!isIgnoreType){

        }

         filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
