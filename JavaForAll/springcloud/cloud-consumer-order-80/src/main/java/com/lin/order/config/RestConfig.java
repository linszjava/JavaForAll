package com.lin.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud
 * @description: Rest服务调用配置类
 * @author: linsz
 * @create: 2022-08-12 15:46
 **/
@Configuration
public class RestConfig {

    @Bean
//    注释掉@LoadBalanced 只是为了测试手写自定义的轮询算法
//    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
