package com.lin.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: springcloud
 * @description: order 主启动类
 * @author: linsz
 * @create: 2022-09-02 11:23
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.lin.order.mapper")
public class MainOrder7001 {
    public static void main(String[] args) {
        SpringApplication.run(MainOrder7001.class,args);
    }
}
