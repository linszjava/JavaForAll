package com.lin.pojo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserTest {

    @Autowired
    private User user;

    @Test
    public void testToString() {
        System.out.println(user);
    }
}