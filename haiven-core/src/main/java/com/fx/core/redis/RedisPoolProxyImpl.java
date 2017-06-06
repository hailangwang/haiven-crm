package com.fx.core.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by hlwang on 2017/6/1.
 */

public class RedisPoolProxyImpl implements  RedisPoolProxy {


    private ShardedJedisPool shardedJedisPool;

    public ShardedJedis getRedisClient() {
        return shardedJedisPool.getResource();
    }

    public void returnBrokenResourceObject(ShardedJedis shardedJedis) {
          shardedJedis.close();
//        3.0开始已表示丢弃方法  使用 close代替
//        shardedJedisPool.returnBrokenResource(shardedJedis);
    }

    public void returnResource(ShardedJedis shardedJedis) {
          shardedJedis.close();
//        3.0开始已表示丢弃方法  使用 close代替
//        shardedJedisPool.returnResource(shardedJedis);
    }
}
