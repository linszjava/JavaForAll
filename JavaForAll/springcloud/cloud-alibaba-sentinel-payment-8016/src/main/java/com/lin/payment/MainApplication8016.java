package com.lin.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description: 主启动类
 * @author: linsz
 * @create: 2022-08-31 18:02
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplication8016 {

    public static void main(String[] args) {

        SpringApplication.run(MainApplication8016.class,args);
    }
}
