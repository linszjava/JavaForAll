package com.lin.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.config.JCacheConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

/**
 * @program: maven-other
 * @description: redis配置类  如果你这个redis完全不配，没有问题，底层会帮你自动配置一个
 * 但是你会发现，你输入的key在序列化到redis当中，会出现乱码的问题 比如
 * \xAC\xED\x00\x05t\x00\x06\xE6\x9E\x97\xE8\xB0\xA6
 * @author: linsz
 * @create: 2022-07-07 02:14
 **/
@EnableCaching
@Configuration
public class RedisConfig {


    // 网上找的方法 可行，但应该不完整
    @Bean
    RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());//支持直接序列化对象
        return redisTemplate;
    }


}
