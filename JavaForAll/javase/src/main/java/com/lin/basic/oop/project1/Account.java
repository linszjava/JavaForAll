package com.lin.basic.oop.project1;

/**
 * @program: Java
 * @description: 模拟账户测试
 * @author: linsz
 * @create: 2022-06-04 15:40
 **/
public class Account {

    //账号
    private int id;
    //余额
    private double balance;
    //年利率
    private double annualInterestRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * 取钱
     *
     * @param amount
     */
    public void withdraw(double amount) {
        if (this.balance < amount) {
            System.out.println("余额不足，取款失败");
        } else {
            this.balance -= amount;
            System.out.println("成功取出：" + amount);
        }


    }

    /**
     * 存钱
     *
     * @param amount
     */
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("成功存入：" + amount);
    }
}
