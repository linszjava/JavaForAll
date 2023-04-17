package com.lin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: docker-springboot
 * @description: 测试docker, 简单写一个端口测试
 * @author: linsz
 * @create: 2022-07-22 06:06
 **/
@RestController
public class TestController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/test/getPort")
    public String getPort() {
        return UUID.randomUUID().toString() + " " + applicationName + " " +
                port;
    }
}
