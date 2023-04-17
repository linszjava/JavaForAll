package com.lin.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description: sentinel service 主启动类
 * @author: linsz
 * @create: 2022-08-28 01:06
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplicationSentinel8015 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplicationSentinel8015.class,args);
    }
}
