package com.lin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springmvc
 * @description: HelloController测试类
 * @author: linsz
 * @create: 2022-06-25 07:35
 **/
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/target")
    public String target() {
        return "target";
    }


}
