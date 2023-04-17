package com.lin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: springcloud
 * @description: openfeign主启动类
 * @author: linsz
 * @create: 2022-08-18 21:52
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OpenfeignMainApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(OpenfeignMainApplication80.class,args);
    }
}
