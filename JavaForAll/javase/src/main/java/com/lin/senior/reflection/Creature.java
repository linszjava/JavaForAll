package com.lin.senior.reflection;

import java.io.Serializable;

/**
 * @program: javase
 * @description: 生物 entity
 * @author: linsz
 * @create: 2022-06-13 03:52
 **/
public class Creature<T> implements Serializable {

    private static final long serialVersionUID = 433233252L;

    private int height;
    public double weight;

    public void walk() {
        System.out.println("生物能移动--");
    }

    public void eat() {
        System.out.println("生物能进食---");
    }
}
