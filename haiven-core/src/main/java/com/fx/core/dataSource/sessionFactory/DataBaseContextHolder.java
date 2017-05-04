package com.fx.core.dataSource.sessionFactory;

import com.fx.core.util.StringUtils;

/**
 * Created by hlwang on 2017/5/4.
 */
public class DataBaseContextHolder {

    private  static  final  ThreadLocal<String> contenxtHolder = new ThreadLocal<String>();


    public static String getDbType(){
       String dbType = contenxtHolder.get();
       return  StringUtils.isNotEmpty(dbType)?"dataSource":dbType;

    }

    public static void setDbType(String dbType){
        if(StringUtils.isEmpty(dbType)){
            dbType="dataSource";
        }
        contenxtHolder.set(dbType);
    }

    public static void celarDbType(){
        contenxtHolder.remove();
    }

}
