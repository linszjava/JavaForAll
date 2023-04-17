package com.lin.spring.service;

import com.lin.spring.dao.BookDao;

/**
 * @program: JavaForAll
 * @description: BookService 业务层
 * @author: linsz
 * @create: 2022-06-24 00:49
 **/
public class BookService {

    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBook() {
        System.out.println("我是bookService中的addBook方法");
        bookDao.addBook();
    }
}
