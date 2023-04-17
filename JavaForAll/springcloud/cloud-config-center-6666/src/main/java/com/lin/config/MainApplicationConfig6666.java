package com.lin.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @program: springcloud
 * @description: config 微服务 主启动类
 * @author: linsz
 * @create: 2022-08-23 18:13
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class MainApplicationConfig6666 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplicationConfig6666.class,args);
    }
}
