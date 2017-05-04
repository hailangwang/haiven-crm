package com.fx.core.dataSource.pagingDialect;

/**
 * Created by hlwang on 2017/5/4.
 */
public interface PagingDialect {

    boolean supportsPaging();

    String getPagingSql(String sql,int offset,int limit);

}
