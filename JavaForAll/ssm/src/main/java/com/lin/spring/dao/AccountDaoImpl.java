package com.lin.spring.dao;

import com.lin.spring.utils.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @program: JavaForAll
 * @description: AccountDao实现类
 * @author: linsz
 * @create: 2022-06-25 03:52
 **/
@Repository
public class AccountDaoImpl implements AccountDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addBalance() {

        String sql = "update  account set balance = balance + ? where name = ? ";
        int update = jdbcTemplate.update(sql, 200.0, "李四");
    }

    @Override
    public void reduceBalance() {

        String sql = "update  account set balance = balance - ? where name = ? ";
        int update = jdbcTemplate.update(sql, 200.0, "张三");

    }
}
