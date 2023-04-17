package com.lin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot
 * @description: 测试springboot
 * @author: linsz
 * @create: 2022-06-30 04:09
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String testHello() {
        return "hello springboot 2!";
    }
}
