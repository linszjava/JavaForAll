package com.lin.controller;

import com.lin.pojo.User;
import com.lin.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot
 * @description: 内容解析测试控制器  根据浏览器所需要的返回值类型，有可能不是要返回json之类的场景
 * @author: linsz
 * @create: 2022-07-01 18:00
 **/
@RestController
public class ContentController {

    @Autowired
    private MyService myService;

    @GetMapping("/getName")
    public String getName() {
        return myService.getAllName("曼德拉");
    }

    @GetMapping("/getUser")
    public User getUser() {
        return new User(1002, "林谦", "xmu");
    }
}
