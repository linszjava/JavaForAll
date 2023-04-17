package com.lin.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.swing.*;

/**
 * @program: springcloud
 * @description: nacos 注册  payment 主启动类
 * @author: linsz
 * @create: 2022-08-25 16:54
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplicationNacos8010 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplicationNacos8010.class,args);
    }
}
