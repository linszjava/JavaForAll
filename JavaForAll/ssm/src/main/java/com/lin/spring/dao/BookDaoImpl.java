package com.lin.spring.dao;

/**
 * @program: JavaForAll
 * @description: BookDao实现类
 * @author: linsz
 * @create: 2022-06-24 00:51
 **/
public class BookDaoImpl implements BookDao {
    @Override
    public void addBook() {
        System.out.println("我是bookDao接口层的AddBook方法");
    }
}
