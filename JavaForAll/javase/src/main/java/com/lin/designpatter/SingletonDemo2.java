package com.lin.designpatter;

/**
 * @program: javase
 * @description: 单例设计模式 懒汉式
 * @author: linsz
 * @create: 2022-06-05 16:25
 **/
public class SingletonDemo2 {
    public static void main(String[] args) {
        Singleton_ instance = Singleton_.getInstance();
        Singleton_ instance1 = Singleton_.getInstance();
        System.out.println(instance == instance1);
    }
}

class Singleton_ {

    //1. 私有化构造器
    private Singleton_() {

    }

    //2. 声明一个static 的实例
    private static Singleton_ instance = null;

    //3. 对外暴露一个获取该实例的接口  下面的写法多线程下是不安全的
    public static Singleton_ getInstance() {
        if (instance == null) {
            System.out.println("你们还是只能调用同一个");
            instance = new Singleton_();
        }
        return instance;
    }


}