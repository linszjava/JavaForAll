package com.lin.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: springcloud
 * @description: 以nacos 为注册中心的 客户端
 * @author: linsz
 * @create: 2022-08-25 17:27
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MainApplicationNacos80 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplicationNacos80.class,args);
    }
}
