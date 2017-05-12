package com.fx.core.filter;

import com.fx.core.util.ContantUtil;
import com.fx.core.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by hlwang on 2017/5/8.
 */
public class WebFilter implements Filter {

    private String ignoreTypes;
    private final String CACHEOFF = "cacheoff";

    private boolean isIgnoreType;

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getServletContext().getServletContextName());
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String url = request.getContextPath();
        String[] ignoreType=null;
        if(StringUtils.isNotEmpty(ignoreTypes)){
            ignoreType = ignoreTypes.split(ContantUtil.DOT);
        }

        if(ignoreType!=null && ignoreType.length>0){
            for(int i=0;i<ignoreType.length;i++){
                if(url.endsWith("."+ignoreType[i])){
                    isIgnoreType =true;
                    break;
                }
            }
        }
        if(!isIgnoreType){
                 // js缓存
                String CacheSwich = (String) request.getSession().getAttribute("CacheSwich");
                if ( CACHEOFF.equals(CacheSwich)) {
                    request.getSession().setAttribute("cacheVersion", "jsnotchange");
                }
                else {
                    request.getSession().setAttribute("cacheVersion","?"+ UUID.randomUUID().toString());
                }
                request.getSession().setAttribute("scripts",request.getContextPath() + "/scripts");
                request.getSession().setAttribute("img",request.getContextPath() + "/images");
                request.getSession().setAttribute("css",request.getContextPath() + "/styles");
                request.getSession().setAttribute("projectName",request.getSession().getServletContext().getServletContextName());
                System.out.println(request.getSession().getServletContext().getServletContextName());

        }

         filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }

    public String getIgnoreTypes() {
        return ignoreTypes;
    }

    public void setIgnoreTypes(String ignoreTypes) {
        this.ignoreTypes = ignoreTypes;
    }
}
