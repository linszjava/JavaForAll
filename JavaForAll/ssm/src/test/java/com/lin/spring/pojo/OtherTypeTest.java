package com.lin.spring.pojo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class OtherTypeTest {

    /**
     * 测试其他类型的属性注入
     */
    @Test
    public void getOtherType() {

        OtherType otherType = new ClassPathXmlApplicationContext("beans/spring4.xml")
                .getBean("otherType", OtherType.class);
        System.out.println(otherType);
    }
}