package com.lin.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @program: springcloud
 * @description: hystrix dashboard 主启动类
 * @author: linsz
 * @create: 2022-08-22 16:51
 **/
@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
public class MainApplicationDashboard9001 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplicationDashboard9001.class,args);
    }
}
