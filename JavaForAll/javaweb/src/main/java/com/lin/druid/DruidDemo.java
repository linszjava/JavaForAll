package com.lin.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @program: JavaForAll
 * @description: druid连接池的测试
 * @author: linsz
 * @create: 2022-06-17 15:26
 **/
public class DruidDemo {
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        // System.out.println(System.getProperty("user.dir"));
        properties.load(new FileInputStream("/Users/linsz/Documents/idea/JavaForAll/javaweb/src/main/resources/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}
