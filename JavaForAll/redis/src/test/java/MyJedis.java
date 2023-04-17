package com.lin;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: springboot-other-tech
 * @description: jedis测试类
 * @author: linsz
 * @create: 2022-07-06 18:25
 **/
public class MyJedis {
    static Jedis redis = null;

    static {
        redis = new Jedis("localhost", 6379);
    }

    @Test
    public void testJedis() {
//        Jedis redis = new Jedis("localhost", 6379);

        System.out.println(redis.ping());
    }

    @Test
    public void testString() {
        redis.select(0);
        System.out.println("redis.keys(\"*\") = " + redis.keys("*"));
        String k1 = redis.get("k1");
        System.out.println(k1);
        System.out.println(redis.set("jedis", "myJedis"));

    }

    @Test
    public void testList() {
        redis.select(1);
        List<String> stringList = redis.lrange("k1", 0, -1);
        stringList.forEach(s -> System.out.println(s));
        System.out.println("--------------");
        redis.lpush("v5", "kd", "sc", "kt", "ym");
        List<String> rpop = redis.rpop("v5", 2);
        rpop.forEach(r -> System.out.println(r));
    }

    @Test
    public void testSet() {
        redis.select(2);
        redis.sadd("k3", "1", "2", "3");
        System.out.println(redis.smembers("k3"));
        System.out.println(redis.sismember("k3", "4"));
        redis.srem("k3", "2");
    }

    @Test
    public void testHash() {
        redis.select(3);
        System.out.println(redis.keys("*"));
        System.out.println(redis.hgetAll("k1"));
        HashMap<String, String> map = new HashMap<>();
        //新放的键与原来的相同会覆盖
        map.put("name", "帅哥");
        map.put("id", "110");
        redis.hset("k1", map);
        redis.hset("stu", "id", "1001");
        System.out.println("----------");
        Set<String> keys = redis.keys("*");
        for (String key : keys) {
            System.out.println(key);
            Map<String, String> hgetAll = redis.hgetAll(key);
            hgetAll.forEach((s, s2) -> System.out.println(s + ":" + s2));
            System.out.println("@@@@@@@@@@@@@2");
        }
    }

    @Test
    public void testZset() {
        redis.select(5);
        redis.zadd("lan", 100, "java");
        redis.zadd("lan", 110, "C++");
        redis.zadd("lan", 200, "Mysql");
        List<String> lis = redis.zrange("lan", 0, -1);
        List<String> stringList = redis.zrevrangeByScore("lan", 200, 0);
//        lis.forEach(System.out::println);
        stringList.forEach(System.out::println);
    }
}
