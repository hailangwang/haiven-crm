package com.fx.core.redis;

/**
 * Created by hlwang on 2017/6/1.
 */
public interface RedisCacheStorage<V, K> {

     V get(K key);



}
