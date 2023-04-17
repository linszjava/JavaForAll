package com.lin.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springcloud
 * @description: 自定义ribbon 规则
 * @author: linsz
 * @create: 2022-08-18 17:35
 **/
@Configuration
public class MyRibbonRule {

    @Bean
    public IRule rule(){
        return new RandomRule();//随机
    }
}
