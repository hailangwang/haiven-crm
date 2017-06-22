package com.fx.core.redis.cluster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by hlwang on 2017/6/9.
 */
@Service
public interface RedisService<K,V> {

    public V getKey(K k);

    public void setKey(K k,V v);

    public void setKey(K k,V v,int exp);


}
