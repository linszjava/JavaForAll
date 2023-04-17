package com.lin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

/**
 * @program: springmvc
 * @description: 请求参数传参测试
 * @author: linsz
 * @create: 2022-06-27 01:34
 **/
@Controller
public class ParamController {

    /**
     * 测试请求参数接收
     *
     * @param username
     * @param password
     * @param hobby
     * @return 结果
     * username:linsz
     * password:deee
     * hobby:[篮球, 足球, 橄榄球]
     */
    @RequestMapping("/testParam")
    public String testParam(@RequestParam(value = "user_name", required = false, defaultValue = "linsz") String username, String password, String[] hobby) {
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("hobby:" + Arrays.toString(hobby));
        return "success";
    }
}
