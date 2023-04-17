package com.lin.service;

import com.lin.bean.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: linsz-spring-boot-starter-autoconfigure
 * @description: 自定义一个业务类
 * @author: linsz
 * @create: 2022-07-05 03:55
 **/
public class MyService {

    @Autowired
    private MyProperties myProperties;

    public String getAllName(String name) {
        return myProperties.getPrefix() + name + myProperties.getSuffix();
    }
}
