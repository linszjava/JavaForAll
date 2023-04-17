package com.lin.senior.generic;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @program: javase
 * @description: 测试Dao泛型
 * @author: linsz
 * @create: 2022-06-10 14:30
 **/
public class DaoTestDemo {

    @Test
    public void testDAO() {
        UserDao userDao = new UserDao();

        List<User> users = userDao.listAll(Arrays.asList(1, 3, 4));  //List<User>

        userDao.add(new User());
    }
}
