package com.lin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description: Consul之payment微服务测试主启动类
 * @author: linsz
 * @create: 2022-08-17 19:09
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplicationConsul8005 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplicationConsul8005.class,args);
    }
}
