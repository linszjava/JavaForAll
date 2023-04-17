package com.lin.basic.oop.project1;

/**
 * @program: Java
 * @description: 用户类
 * @author: linsz
 * @create: 2022-06-04 15:43
 **/
public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void showInfo(Account account) {
        System.out.println("Customer [" + this.getFirstName() + "," + this.lastName + "]" +
                " has a account: id is " + account.getId() + ",annualInterestRate is " + account.getAnnualInterestRate() + "%,balance is " + account.getBalance());
    }
}
