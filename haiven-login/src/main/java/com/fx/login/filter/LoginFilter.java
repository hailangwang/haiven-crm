package com.fx.login.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by hlwang on 2017/5/8.
 */
public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
