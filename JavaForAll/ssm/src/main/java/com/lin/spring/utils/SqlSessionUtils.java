package com.lin.spring.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: JavaForAll
 * @description: 数据库连接工具类
 * @author: linsz
 * @create: 2022-06-23 03:51
 **/
public class SqlSessionUtils {


    public static SqlSessionFactory getSqlSessionFactory() {
        InputStream resource = null;
        try {
            resource = Resources.getResourceAsStream("mybatis-config-spring.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession(boolean flag) {
        return getSqlSessionFactory().openSession(flag);
    }
}
