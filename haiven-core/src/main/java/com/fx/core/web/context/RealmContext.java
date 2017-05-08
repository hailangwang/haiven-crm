package com.fx.core.web.context;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hlwang on 2017/5/8.
 */
public class RealmContext {

    private static RealmContext REALM_CONTEXT = new RealmContext();

    private String basePath;

    public RealmContext(){};

    public static RealmContext getRealmContext(){
        return REALM_CONTEXT;
    }


    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(HttpServletRequest request) {
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        if(!basePath.equals(REALM_CONTEXT.basePath)){
            REALM_CONTEXT.basePath = basePath;
        }
    }
}
