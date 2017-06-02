package com.fx.core.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fx.core.redis.exception.RedisException;
import com.fx.core.redis.service.RedisService;
import com.fx.core.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;

/**
 * Created by hlwang on 2017/6/1.
 */
@Service
public class RedisCacheStorageImpl<V, K> implements  RedisCacheStorage<V, K>{

    @Autowired
    private RedisService redisService;

    public V get(K key) {
        ShardedJedis shardedJedis =null;
        String sKey = JSON.toJSONString(key, SerializerFeature.WriteClassName);
        if(StringUtils.isEmpty(sKey)){
            throw new RedisException("Key 值不允许为空！");
        }
        shardedJedis = getRedisPoolProxy().getRedisClient();
       try {
           String value = shardedJedis.get(sKey);
           //返回资源池
           getRedisPoolProxy().returnResource(shardedJedis);
           // 处理返回数据
           if(StringUtils.isEmpty(value)){
                 return null;
           }else{
               if("nil".equalsIgnoreCase(value)){
                   throw new RedisException("不存在Key："+sKey);
               }else{
                   return (V) JSON.parse(value);
               }
           }

       }catch (Exception e){
           getRedisPoolProxy().returnResource(shardedJedis);
           throw new RedisException(e);
       }finally {
           getRedisPoolProxy().returnResource(shardedJedis);
       }
    }

    private  RedisPoolProxy getRedisPoolProxy(){
        return  redisService.getRedisPoolProxy();
    }

}
