package com.lin.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description: hystrix主启动类8006
 * @author: linsz
 * @create: 2022-08-21 15:54
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class MainApplicationHystrix8006 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplicationHystrix8006.class,args);
    }
}
