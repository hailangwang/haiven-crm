package com.fx.core.util;

/**
 * Created by hlwang on 2017/5/4.
 */
public class StringUtils {

    public static  boolean isNotEmpty(String s){

        if(s==null ||s.trim().length()<0 )
            return false;
         return  true;

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


    public static String arrayToString(String[] array){
        StringBuilder stringBuilder = new StringBuilder();
        if(array!=null && array.length>0){
            for(int i=0;i<array.length;i++){
                stringBuilder.append(array[i]).append(ContantUtil.DOT);
            }
        }
        return stringBuilder.toString();


    }
}
