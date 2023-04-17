package com.lin.rabbitmq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: rabbitmq-springboot
 * @description: swagger配置类
 * @author: linsz
 * @create: 2022-07-18 03:07
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("rabbitmq-api")
                .select()
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("rabbitmq接口文档")
                .description("本文档描述了rabbitmq微服务的接口定义")
                .version("1.1")
                .contact(new Contact("linsz", "http://localhost:8888", "linszjava@gmail.com"))
                .build();
    }
}
