package com.lin.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: springcloud
 * @description: sentinel-openfein order 端 主启动类
 * @author: linsz
 * @create: 2022-08-31 20:39
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MainApplication9000 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication9000.class,args);
    }
}
