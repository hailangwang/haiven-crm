package com.fx.core.redis.service;

import com.fx.core.redis.RedisPoolProxy;

/**
 * Created by hlwang on 2017/6/1.
 */
public interface RedisService {

    RedisPoolProxy getRedisPoolProxy();
}
