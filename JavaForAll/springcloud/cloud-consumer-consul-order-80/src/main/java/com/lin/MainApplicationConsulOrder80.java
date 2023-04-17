package com.lin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description: consul 主启动类
 * @author: linsz
 * @create: 2022-08-17 19:31
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplicationConsulOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplicationConsulOrder80.class,args);
    }
}
