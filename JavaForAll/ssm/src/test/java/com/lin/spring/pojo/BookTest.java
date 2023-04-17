package com.lin.spring.pojo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookTest {

    /**
     * 测试setter方法注入
     */
    @Test
    public void testSetterDI() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans/spring1.xml");
        Book book = applicationContext.getBean("Book", Book.class);
        System.out.println(book);
    }

    /**
     * 测试构造器注入
     */
    @Test
    public void testConstructorDI() {
        Book book1 = new ClassPathXmlApplicationContext("beans/spring1.xml").getBean("Book1", Book.class);
        System.out.println(book1);
    }


    @Test
    public void testInnerDI() {

        Book book = new ClassPathXmlApplicationContext("beans/spring1.xml")
                .getBean("Book2", Book.class);
        System.out.println(book);

    }

}