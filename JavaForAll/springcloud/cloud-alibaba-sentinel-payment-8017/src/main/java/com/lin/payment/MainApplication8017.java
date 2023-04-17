package com.lin.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description: payment 主启动类
 * @author: linsz
 * @create: 2022-08-31 18:09
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplication8017 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication8017.class,args);
    }
}
