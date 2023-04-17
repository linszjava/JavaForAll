package com.lin.spring.service;

import com.lin.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: JavaForAll
 * @description: UserService实现类
 * @author: linsz
 * @create: 2022-06-24 06:03
 **/
@Service("userService")
public class UserService {

    @Autowired
    private UserDao userDao;

    public void addUser() {
        System.out.println("userService中的addUser方法");
        userDao.add();
    }
}
