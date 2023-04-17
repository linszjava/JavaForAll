package com.lin.spring.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: JavaForAll
 * @description: 事务测试 ：账号接口
 * @author: linsz
 * @create: 2022-06-25 03:01
 **/
//@Mapper
public interface AccountDao {

    /**
     * 收账
     */
    void addBalance();

    /**
     * 转账
     */
    void reduceBalance();
}
