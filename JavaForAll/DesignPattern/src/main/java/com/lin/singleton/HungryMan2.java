package com.lin.singleton;

/**
 * @program: JavaForAll
 * @description: 静态代码块
 * @author: linsz
 * @create: 2022-11-15 17:34
 **/
public class HungryMan2 {
    public static void main(String[] args) {
        SingletonTest2 instance = SingletonTest2.getInstance();
        SingletonTest2 instance1 = SingletonTest2.getInstance();

        System.out.println(instance.equals(instance1));

        System.out.println(instance.hashCode() == instance.hashCode());
    }

}

class SingletonTest2{

    private SingletonTest2(){}

    private static SingletonTest2 instance;

    // 类比饿汉式静态常量
    static {
        instance = new SingletonTest2();
    }

    public static SingletonTest2 getInstance(){
        return instance;
    }

}
