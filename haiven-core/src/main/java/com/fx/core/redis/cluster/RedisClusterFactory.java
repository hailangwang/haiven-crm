package com.fx.core.redis.cluster;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.Set;

/**
 * Created by hlwang on 2017/6/8.
 */
@Component
public class RedisClusterFactory implements FactoryBean , InitializingBean {

    private JedisCluster jedisCluster;
    private int timeOut;
    private int maxAttempts;
    private GenericObjectPoolConfig poolConfig;
    private Set<HostAndPort> nodes;

   public  RedisClusterFactory( Set<HostAndPort> nodes, int timeOut, int maxAttempts, GenericObjectPoolConfig poolConfig){

       this.timeOut = timeOut;
       this.nodes =nodes;
       this.poolConfig = poolConfig;
       this.maxAttempts = maxAttempts;

   }

    public RedisClusterFactory(){

    }



    public JedisCluster getObject() throws Exception {
        return this.jedisCluster;
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return true;
    }

    public void afterPropertiesSet() throws Exception {

      this.jedisCluster =  new JedisCluster(this.nodes,this.timeOut,this.maxAttempts,this.poolConfig);
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public void setPoolConfig(GenericObjectPoolConfig poolConfig) {
        this.poolConfig = poolConfig;
    }

    public void setNodes(Set<HostAndPort> nodes) {
        this.nodes = nodes;
    }
}
