package com.lin.spring.aop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserProxy1Test {

    /**
     * 使用xml配置实现aop
     */
    @Test
    public void before() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans/spring6.xml");
        classPathXmlApplicationContext.getBean("user1", User1.class).add();
    }
}