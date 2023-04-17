package com.lin.config;

import com.lin.converter.MyConverter;
import com.lin.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: springboot
 * @description: 自定义配置类
 * @author: linsz
 * @create: 2022-06-30 07:24
 **/
@Configuration(proxyBeanMethods = true) //默认为true 保证每个@Bean方法被调用多少次返回的组件都是单实例的
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        HashMap<String, MediaType> mediaTypeHashMap = new HashMap<>();
        mediaTypeHashMap.put("json", MediaType.APPLICATION_JSON);
        mediaTypeHashMap.put("xml", MediaType.APPLICATION_XML);
        mediaTypeHashMap.put("my", MediaType.parseMediaType("application/my-type"));
        configurer.mediaTypes(mediaTypeHashMap);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MyConverter());
    }

//    @Bean("myUser")
//    public User user(){
//        return new User("林谦");
//    }


}
