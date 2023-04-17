package com.lin.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description: rabbitmq provider 8007 主启动类  生产者端
 * @author: linsz
 * @create: 2022-08-24 14:19
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplicationRabbitmqProvider8007 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplicationRabbitmqProvider8007.class,args);
    }
}
