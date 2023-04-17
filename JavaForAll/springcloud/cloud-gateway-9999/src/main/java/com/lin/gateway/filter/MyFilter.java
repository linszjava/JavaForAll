package com.lin.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @program: springcloud
 * @description: 自定义全局过滤器
 * @author: linsz
 * @create: 2022-08-23 15:58
 **/
@Component
@Slf4j
public class MyFilter implements GlobalFilter , Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        /**
         * 如果携带的请求参数含u=xmu 则放行通过，如果不然，视为未授权
         */
        Object requiredAttribute = exchange.getRequest().getQueryParams().getFirst("u");
        if (Objects.isNull(requiredAttribute)){
            log.info("携带的参数属性为空或者非xmu,拒绝访问");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        log.info("携带的参数为xmu,放行通过！");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
