package com.lin.spring.bean;

import com.lin.spring.pojo.Course;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class MyBeanTest {

    @Test
    public void getObject() {

        Course myBean = new ClassPathXmlApplicationContext("beans/spring3.xml")
                .getBean("myBean", Course.class);
        System.out.println(myBean);
    }
}