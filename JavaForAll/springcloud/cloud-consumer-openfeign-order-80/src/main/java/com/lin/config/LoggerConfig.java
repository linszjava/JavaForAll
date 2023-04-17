package com.lin.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springcloud
 * @description: openfeign 日志配置
 * @author: linsz
 * @create: 2022-08-21 14:49
 **/
@Configuration
public class LoggerConfig {
    /**
     * openfeign logger 配置类  注意包的导入
     * @return
     */
    @Bean
    public Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }
}
