package com.lin.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description: 网关主启动类
 * @author: linsz
 * @create: 2022-08-23 14:51
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplicationGateway9999 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplicationGateway9999.class,args);
    }
}
