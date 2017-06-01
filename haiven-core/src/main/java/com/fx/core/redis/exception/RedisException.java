package com.fx.core.redis.exception;

import java.io.Serializable;

/**
 * Created by hlwang on 2017/6/1.
 */
public class RedisException extends  RuntimeException {

    public RedisException(String message) {
        super(message);
    }

    public RedisException(Throwable e) {
        super(e);
    }

    public RedisException(String message, Throwable cause) {
        super(message, cause);
    }

}
