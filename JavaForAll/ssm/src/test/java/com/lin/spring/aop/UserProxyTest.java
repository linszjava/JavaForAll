package com.lin.spring.aop;

import com.lin.spring.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class UserProxyTest {

    /**
     * 测试使用注解实现的aop
     */
    @Test
    public void before() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        User user = context.getBean("user", User.class);
        user.add();
    }
}