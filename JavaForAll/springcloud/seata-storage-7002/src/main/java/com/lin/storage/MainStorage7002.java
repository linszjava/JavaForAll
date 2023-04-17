package com.lin.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description: 主启动类
 * @author: linsz
 * @create: 2022-09-02 16:28
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lin.storage.mapper")
public class MainStorage7002 {

    public static void main(String[] args) {
        SpringApplication.run(MainStorage7002.class,args);
    }
}
