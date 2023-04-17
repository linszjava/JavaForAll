package com.lin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description: order主启动类 zk版本
 * @author: linsz
 * @create: 2022-08-17 18:21
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplicationZk80 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplicationZk80.class,args);
    }
}
