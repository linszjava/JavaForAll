package com.lin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @program: Java-Ultimate
 * @description: Jdbc测试
 * @author: linsz
 * @create: 2022-06-16 21:37
 **/
public class JdbcDemo {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/db1";
        Connection connection = DriverManager.getConnection(url, "root", "root");

        Statement statement = connection.createStatement();

        String sql = "update account set balance= 2000 where id = 2";
        int num = statement.executeUpdate(sql);
        System.out.println(num);
        statement.close();
        connection.close();
    }
}
