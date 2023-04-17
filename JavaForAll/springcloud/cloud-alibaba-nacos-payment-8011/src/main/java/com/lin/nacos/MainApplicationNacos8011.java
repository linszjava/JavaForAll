package com.lin.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description: payment 以nacos 为注册中心的 主启动类
 * @author: linsz
 * @create: 2022-08-25 17:02
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplicationNacos8011 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplicationNacos8011.class,args);
    }
}
