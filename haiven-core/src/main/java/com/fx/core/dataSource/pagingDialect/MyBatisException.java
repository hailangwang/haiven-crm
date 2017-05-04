package com.fx.core.dataSource.pagingDialect;

/**
 * Created by hlwang on 2017/5/4.
 */
public class MyBatisException extends RuntimeException {

    public MyBatisException(String message) {
        super(message);
    }

    public MyBatisException(Throwable throwable) {
        super(throwable);
    }
}
