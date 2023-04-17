package redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @program: maven-other
 * @description: 测试redis
 * @author: linsz
 * @create: 2022-07-07 02:17
 **/
public class MyRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis() {
        redisTemplate.opsForValue().set("redis", "test");
        Object redis = redisTemplate.opsForValue().get("redis");
        System.out.println(redis);

    }
}
