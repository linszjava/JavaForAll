package com.lin.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @program: JavaForAll
 * @description: 测试AOP 使用注解实现
 * @author: linsz
 * @create: 2022-06-24 17:25
 **/
@Component
public class User {

    public void add() {
        System.out.println("user中的add方法被执行了");
    }


}
