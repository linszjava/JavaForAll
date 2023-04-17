package com.lin.spring.dao;

import org.springframework.stereotype.Repository;

/**
 * @program: JavaForAll
 * @description: UserdaoImpl 实现类
 * @author: linsz
 * @create: 2022-06-24 06:01
 **/
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("userDao的add方法");
    }
}
