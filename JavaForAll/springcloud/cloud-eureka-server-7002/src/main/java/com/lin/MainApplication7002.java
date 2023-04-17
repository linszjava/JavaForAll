package com.lin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: springcloud
 * @description: eureka主启动类 7002
 * @author: linsz
 * @create: 2022-08-16 15:15
 **/
@SpringBootApplication
@EnableEurekaServer
public class MainApplication7002 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication7002.class,args);
    }
}
