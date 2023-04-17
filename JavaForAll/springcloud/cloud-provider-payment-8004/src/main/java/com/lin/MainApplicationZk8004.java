package com.lin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description: zookeeper微服务主启动类
 * @author: linsz
 * @create: 2022-08-17 17:30
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplicationZk8004 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplicationZk8004.class,args);
    }
}
