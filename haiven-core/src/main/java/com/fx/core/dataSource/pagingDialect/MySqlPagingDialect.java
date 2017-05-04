package com.fx.core.dataSource.pagingDialect;

/**
 * Created by hlwang on 2017/5/4.
 */
public class MySqlPagingDialect implements  PagingDialect{

    private static final String LIMIT = " limit ";

    public boolean supportsPaging() {
        return true;
    }

    public String getPagingSql(String sql, int offset, int limit) {
        if(offset>0){
            return sql + LIMIT + Integer.toString(offset) +"," +Integer.toString(limit);
        }else {
            return sql + LIMIT + Integer.toString(limit);
        }
    }





}
