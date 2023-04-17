package com.lin.spring.service;

import com.lin.spring.dao.AccountDao;
import com.lin.spring.utils.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: JavaForAll
 * @description: AccountService 测试 事务
 * @author: linsz
 * @create: 2022-06-25 03:10
 **/
@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public void transferBalance() {

        accountDao.reduceBalance();

        accountDao.addBalance();
    }
}
