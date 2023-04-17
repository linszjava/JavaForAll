package com.lin.springsecurity.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @program: springsecurity
 * @description: 配置类 对应web.xml中的ContextLoadListenter
 * @author: linsz
 * @create: 2022-10-20 17:41
 **/
@Configuration
@ComponentScan(basePackages = {"com.lin.springsecurity.springmvc"},
                excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class ApplicationConfig {
}
