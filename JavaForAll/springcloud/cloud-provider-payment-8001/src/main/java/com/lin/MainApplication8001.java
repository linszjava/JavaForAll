package com.lin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcloud
 * @description: 主启动类
 * @author: linsz
 * @create: 2022-08-11 18:55
 **/
@SpringBootApplication
@MapperScan("com.lin.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class MainApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication8001.class,args);
    }
}
