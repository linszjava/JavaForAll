package com.lin.basic.oop.project1;

/**
 * @program: Java
 * @description: 银行账户与客户测试类
 * @author: linsz
 * @create: 2022-06-04 15:54
 **/
public class CustomerAndAccountTestDemo {
    public static void main(String[] args) {
        Customer Js = new Customer("Jane", "Smith");
        Account account = new Account(1000, 2000, 1.23);
        Js.setAccount(account);
        Js.getAccount().deposit(100);
        Js.getAccount().withdraw(960);
        Js.getAccount().withdraw(2000);
        Js.showInfo(account);
    }
}
