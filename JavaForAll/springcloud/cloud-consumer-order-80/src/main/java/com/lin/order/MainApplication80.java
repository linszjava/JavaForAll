package com.lin.order;

import com.lin.rule.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @program: springcloud
 * @description: 订单服务的主启动
 * @author: linsz
 * @create: 2022-08-12 15:42
 **/
@SpringBootApplication
@EnableEurekaClient
//自定义ribbon 规则 注意把配置类的@LoadBalance注释掉
@RibbonClient(value = "CLOUD-PAYMENT-SERVICE",configuration = MyRibbonRule.class)
public class MainApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication80.class,args);
    }
}
