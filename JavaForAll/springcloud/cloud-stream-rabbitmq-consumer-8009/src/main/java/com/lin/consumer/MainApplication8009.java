package com.lin.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description: Consumer 主启动类 8009
 * @author: linsz
 * @create: 2022-08-24 16:29
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplication8009 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication8009.class,args);
    }
}
