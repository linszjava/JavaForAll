package com.lin.account;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description: 主启动类
 * @author: linsz
 * @create: 2022-09-02 16:39
 **/
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lin.account.mapper")
public class MainAccount7003 {

    public static void main(String[] args) {
        SpringApplication.run(MainAccount7003.class,args);
    }
}
