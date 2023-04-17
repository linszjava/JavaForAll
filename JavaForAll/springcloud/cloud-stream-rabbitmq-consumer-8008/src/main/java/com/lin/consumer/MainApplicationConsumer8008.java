package com.lin.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description: stream consumer 8008 主启动类
 * @author: linsz
 * @create: 2022-08-24 15:53
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplicationConsumer8008 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplicationConsumer8008.class,args);
    }
}
