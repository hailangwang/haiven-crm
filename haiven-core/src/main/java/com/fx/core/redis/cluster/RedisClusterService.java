package com.fx.core.redis.cluster;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by hlwang on 2017/6/5.
 */
public class RedisClusterService<K,V> extends RedisTemplate {


   public V getKey(K k){


       return (V) "s";
   }

}
