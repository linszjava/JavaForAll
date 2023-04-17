package com.lin.jdbc;

import java.sql.*;

/**
 * @program: Java-Ultimate
 * @description: Jdbc测试PrepareStatement
 * @author: linsz
 * @create: 2022-06-16 21:37
 **/
public class JdbcPrepareStatementDemo {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/db1";
        Connection connection = DriverManager.getConnection(url, "root", "root");

        String sql = "select * from tb_user where username = ? and password = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, "zhangsan");
        preparedStatement.setString(2, "123");


        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        preparedStatement.close();
        connection.close();
    }
}
