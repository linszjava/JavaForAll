package com.lin.designpatter;

/**
 * @program: javase
 * @description: 单例模式1：饿汉式
 * @author: linsz
 * @create: 2022-06-05 16:10
 **/
public class SingletonDemo1 {
    public static void main(String[] args) {
        //4. 测试是否为饿汉式单例模式
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance2 == instance1);
    }

}

class Singleton {

    //1. 定义私有构造器  不让你new
    private Singleton() {

    }

    //2. 用我自己声明的实例
    private static Singleton instance = new Singleton();

    //3.对外暴露该实例
    public static Singleton getInstance() {
        System.out.println("你调用的只有我");
        return instance;
    }
}
