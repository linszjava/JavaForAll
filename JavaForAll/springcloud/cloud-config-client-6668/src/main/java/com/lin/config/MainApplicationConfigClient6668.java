package com.lin.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import sun.applet.Main;

/**
 * @program: springcloud
 * @description: config client 6668 主启动类
 * @author: linsz
 * @create: 2022-08-23 23:17
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplicationConfigClient6668 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplicationConfigClient6668.class,args);
    }
}
