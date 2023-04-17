package com.lin.spring.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program: JavaForAll
 * @description: User增强类 使用xml 实现
 * @author: linsz
 * @create: 2022-06-24 17:26
 **/
public class UserProxy1 {


    public void before() {
        System.out.println("before.......");
    }

    public void after() {
        System.out.println("after.......");
    }

    public void afterReturning() {
        System.out.println("afterReturning.......");
    }


}
