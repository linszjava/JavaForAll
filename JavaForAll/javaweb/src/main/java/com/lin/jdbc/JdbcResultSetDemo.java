package com.lin.jdbc;

import com.lin.beans.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @program: Java-Ultimate
 * @description: ResultSet 测试
 * @author: linsz
 * @create: 2022-06-16 21:37
 **/
public class JdbcResultSetDemo {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/db1";
        Connection connection = DriverManager.getConnection(url, "root", "root");

        Statement statement = connection.createStatement();

        String sql = "select * from account";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Account> accounts = new ArrayList<>();
        while (resultSet.next()) {
            Account account = new Account();
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double balance = resultSet.getDouble("balance");
            account.setId(id).setName(name).setBalance(balance);
            accounts.add(account);

        }
        System.out.println(accounts);
        statement.close();
        connection.close();
    }
}
