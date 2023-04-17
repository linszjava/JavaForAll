package com.lin.spring.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCDemoTest {

    @Test
    public void testAdd() {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans/spring.xml");
        IOCDemo iocDemo = applicationContext.getBean("userTest", IOCDemo.class);
        iocDemo.testAdd();
    }
}