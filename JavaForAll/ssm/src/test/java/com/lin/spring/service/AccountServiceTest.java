package com.lin.spring.service;

import com.lin.spring.dao.AccountDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void transferBalance() {

        accountService.transferBalance();
    }
}