package com.fx.core.redis.cluster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by hlwang on 2017/6/9.
 */
public class RedisServiceImpl<K,V> implements  RedisService<K,V> {

   @Autowired
   private RedisTemplate redisTemplate;

    public V getKey(K k) {
    
//        return redisTemplate.opsForValue().get(k);
        return (V)"s";
    }

    public void setKey(K k, V v) {

    }

    public void setKey(K k, V v, int exp) {

    }
}
