package com.lin.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: springcloud
 * @description: hystrix order 主启动类
 * @author: linsz
 * @create: 2022-08-21 17:06
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class MainApplicationHystrix80 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplicationHystrix80.class,args);
    }
}
