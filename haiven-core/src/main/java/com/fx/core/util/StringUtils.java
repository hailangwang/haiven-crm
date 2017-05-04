package com.fx.core.util;

/**
 * Created by hlwang on 2017/5/4.
 */
public class StringUtils {

    public static  boolean isNotEmpty(String s){


         return  false;

    }


    public static  boolean isEmpty(String s){

        if(s==null){
            return true;
        } else {
            s= s.trim();
            if(s.length()<=0){
                return true;
            }
            return false;
        }
    }
}
