package com.fx.core.redis.service;

import com.fx.core.redis.RedisPoolProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hlwang on 2017/6/1.
 */
@Service
public class RedisServiceImpl implements  RedisService {

   @Autowired
   private RedisPoolProxy redisPoolProxy;

    public RedisPoolProxy getRedisPoolProxy() {
        return redisPoolProxy;
    }
}
