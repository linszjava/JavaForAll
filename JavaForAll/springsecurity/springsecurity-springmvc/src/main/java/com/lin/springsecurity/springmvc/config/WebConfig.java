package com.lin.springsecurity.springmvc.config;

import com.lin.springsecurity.springmvc.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @program: springsecurity
 * @description: 配置类 ServletContext 对应 DispatcherServlet配置
 * @author: linsz
 * @create: 2022-10-20 17:45
 **/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.lin.springsecurity.springmvc",
                includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class WebConfig implements WebMvcConfigurer {


    @Autowired
    private MyInterceptor myInterceptor;
    // 视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    //视图控制器
    public void addViewControllers(ViewControllerRegistry registry){
        // WebConfig中新增如下配置，将/直接导向login.jsp页面
        registry.addViewController("/").setViewName("login");
    }

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/r/**");
    }
}
