package com.lin.config;

import com.lin.bean.MyProperties;
import com.lin.service.MyService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: linsz-spring-boot-starter-autoconfigure
 * @description: 自动配置类 装载Myservice的Bean
 * @author: linsz
 * @create: 2022-07-05 03:58
 **/
@Configuration
@EnableConfigurationProperties(MyProperties.class)
public class MyAutoConfiguration {

    @ConditionalOnMissingBean(MyService.class)
    @Bean
    public MyService getMyService() {
        return new MyService();
    }
}
