package com.lin.spring.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program: JavaForAll
 * @description: User增强类
 * @author: linsz
 * @create: 2022-06-24 17:26
 **/
@Component
@Aspect
@Order(1)
public class UserProxy {

    @Pointcut("execution(* com.lin.spring.aop.User.add(..))")
    public void pointcutDemo() {

    }


    @Before("pointcutDemo()")
    public void before() {
        System.out.println("before.......");
    }

    @After("execution(* com.lin.spring.aop.User.add(..))")
    public void after() {
        System.out.println("after.......");
    }

    @AfterReturning("execution(* com.lin.spring.aop.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning.......");
    }


}
