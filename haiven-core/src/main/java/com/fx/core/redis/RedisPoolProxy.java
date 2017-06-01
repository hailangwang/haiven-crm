package com.fx.core.redis;

import redis.clients.jedis.ShardedJedis;

/**
 * Created by hlwang on 2017/6/1.
 */
public interface RedisPoolProxy {

    public  abstract ShardedJedis getRedisClient();

    public void returnBrokenResourceObject(ShardedJedis shardedJedis);

    public void returnResource(ShardedJedis shardedJedis);

}
