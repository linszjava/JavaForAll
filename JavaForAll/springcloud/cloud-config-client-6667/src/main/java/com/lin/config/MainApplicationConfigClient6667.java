package com.lin.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description: configClient 主启动类 6667
 * @author: linsz
 * @create: 2022-08-23 22:11
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplicationConfigClient6667 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplicationConfigClient6667.class,args);
    }
}
