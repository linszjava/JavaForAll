package com.lin.senior.reflection;

import lombok.Data;

import java.sql.SQLClientInfoException;

/**
 * @program: javase
 * @description: 人类 entity
 * @author: linsz
 * @create: 2022-06-13 03:51
 **/
@MyAnnotation("haha")
@Data
public class Human extends Creature<String> implements MyInterface {

    @MyAnnotation
    private int id;
    String name;
    public String desc;

    Human() {
    }

    @MyAnnotation("lin")
    private Human(String name) {
        this.name = name;
    }

    public Human(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @MyAnnotation("show")
    public void show(String nation, int age) {
        System.out.println("我的国家是 " + nation + age);
    }

    @Override
    public void showInfo() {
        System.out.println("人能干一些神奇的事情");
    }

    @Override
    public void walk() {
        System.out.println("人能走路 还能跑");
    }

    @Override
    public void eat() {
        System.out.println("人能吃饭还能做饭");
    }

    private void methodPrivate() {
        System.out.println("这是一个私有的方法");
    }

    public void myMethod() throws IllegalAccessException, NullPointerException {
        System.out.println("这是Human类的一个public方法");
    }
}
