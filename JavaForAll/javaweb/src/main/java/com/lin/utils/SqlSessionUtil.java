package com.lin.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: JavaForAll
 * @description: SqlSession工具类封装
 * @author: linsz
 * @create: 2022-06-19 20:30
 **/
public class SqlSessionUtil {

    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        return sqlSession;
    }

    public static SqlSession getSqlSession(boolean flag) throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession(flag);
        return sqlSession;
    }

    public static SqlSession getSqlSessionWithTrue() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession(true);
        return sqlSession;
    }
}
