package com.lin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: Java-Ultimate
 * @description: Jdbc 事务测试
 * @author: linsz
 * @create: 2022-06-16 21:37
 **/
public class JdbcTransactionDemo {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/db1";
        Connection connection = DriverManager.getConnection(url, "root", "root");

        Statement statement = connection.createStatement();

        try {
            connection.setAutoCommit(false);
            String sql1 = "update account set balance= 3000 where id = 2";
            int num1 = statement.executeUpdate(sql1);

            int i = 5 / 0;
            String sql2 = "update account set balance= 3000 where id = 2";
            int num2 = statement.executeUpdate(sql2);

            connection.commit();
            System.out.println(num2);
            System.out.println(num1);
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            statement.close();
            connection.close();
        }

    }
}
