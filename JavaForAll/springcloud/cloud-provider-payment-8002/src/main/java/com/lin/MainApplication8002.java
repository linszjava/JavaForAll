package com.lin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcloud
 * @description: 支付微服务8002端口主启动类
 * @author: linsz
 * @create: 2022-08-16 17:08
 **/
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.lin.mapper")
public class MainApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication8002.class,args);
    }
}
