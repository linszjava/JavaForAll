package com.lin;

import com.lin.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @program: springboot
 * @description: 主启动类
 * @author: linsz
 * @create: 2022-06-30 04:08
 **/
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

//        System.out.println(run.getBeanDefinitionCount());
//        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
//
//        System.out.println("============================");
//        System.out.println(run.getBean(MyConfig.class));

    }
}
