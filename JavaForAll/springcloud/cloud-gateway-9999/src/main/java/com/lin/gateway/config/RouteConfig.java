package com.lin.gateway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * @program: springcloud
 * @description: 使用配置类实现路由转发配置
 * @author: linsz
 * @create: 2022-08-23 15:00
 **/
@Configuration
public class RouteConfig {

    /**
     * 使用代码进行路由定义
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("myRoute", predicateSpec -> predicateSpec.path("/baidu").uri("http://www.baidu.com"));

        return routes.build();
    }
}
