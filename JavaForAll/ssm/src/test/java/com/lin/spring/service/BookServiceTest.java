package com.lin.spring.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class BookServiceTest {

    @Test
    public void addBook() {
        new ClassPathXmlApplicationContext("beans/spring2.xml")
                .getBean("BookService", BookService.class).addBook();
    }
}