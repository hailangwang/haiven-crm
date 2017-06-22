import com.fx.core.redis.cluster.RedisClusterFactory;
import com.fx.login.entity.UserEntity;
import com.fx.login.service.UserService;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hlwang on 2017/6/6.
 */
public class RedisTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisClusterFactory redisClusterFactory;


    @Autowired
    private  RedisTemplate redisTemplate;

    @Autowired
    private JedisConnectionFactory connectionFactory;


    JedisCluster jedisCluster = null;

    static String prefix = "luffi:lbl";
    static String KEY_SPLIT = ":"; //用于隔开缓存前缀与缓存键值

    String nameKey = prefix + KEY_SPLIT + "name";

    /**
     * 因为是测试，这里没有写单例
     */
@Test
    public void Test1(){
        String hosts="192.168.4.181:7001,192.168.4.181:7002,192.168.4.181:7003";
//        String hosts="192.168.4.181:7001";

        String[] serverArray = hosts.split(",");
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();

        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }

        //注意：这里超时时间不要太短，他会有超时重试机制。而且其他像httpclient、dubbo等RPC框架也要注意这点
        jedisCluster = new JedisCluster(nodes, new GenericObjectPoolConfig());

        System.out.println(jedisCluster);

        String s = (String) jedisCluster.get("wang");

        System.out.println(s);
        System.out.println(jedisCluster.get("hai"));
        System.out.println(jedisCluster.get("lang2"));

    }


@Test
    public  void redisTemplateTest(){


    System.out.println(connectionFactory.getClusterConnection());

    System.out.println(redisTemplate);
    redisTemplate.opsForValue().set("gshopper1", "gshopper1");
    redisTemplate.opsForValue().set("wang", "wang");
    System.out.println( redisTemplate.opsForValue().get("gshopper1"));
    redisTemplate.opsForValue().set("gshopper", "gshopper");
    System.out.println( redisTemplate.opsForValue().get("gshopper"));
    System.out.println(redisTemplate.opsForValue().get("wang"));
}




    @Test
    public  void  factoryTest(){
        try {
            jedisCluster = (JedisCluster) redisClusterFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }


        String s = (String) jedisCluster.get("wang");

        System.out.println(s);
        System.out.println(jedisCluster.get("hai"));
        System.out.println(jedisCluster.get("lang2"));
    }

}
