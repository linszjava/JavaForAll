package com.lin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: springcloud
 * @description: eureka服务端主启动
 * @author: linsz
 * @create: 2022-08-15 18:21
 **/
@SpringBootApplication
@EnableEurekaServer
public class MainApplication7001 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication7001.class,args);
    }
}
