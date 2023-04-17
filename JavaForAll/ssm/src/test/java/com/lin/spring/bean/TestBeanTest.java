package com.lin.spring.bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class TestBeanTest {

    @Test
    public void testLifeCircle() {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans/spring5.xml");
        TestBean testBean = context
                .getBean("testBean", TestBean.class);
        System.out.println("第六步：执行bean操作");
        System.out.println(testBean);
        context.close();


    }
}