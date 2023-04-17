package com.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: maven-other
 * @description: 测试redis
 * @author: linsz
 * @create: 2022-07-07 03:13
 **/
@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/test")
    public String getString() {
        redisTemplate.opsForValue().set("name", "林谦");
        String name = (String) redisTemplate.opsForValue().get("name");

        return name;
    }
}
