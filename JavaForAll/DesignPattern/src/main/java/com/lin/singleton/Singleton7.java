package com.lin.singleton;

/**
 * @program: JavaForAll
 * @description: 单例模式  静态内部类
 * @author: linsz
 *          避免了线程不安全 利用了静态内部类实现延迟加载 效率高
 * @create: 2022-11-15 22:18
 **/
public class Singleton7 {

    public static void main(String[] args) {
        SingletonTest7 instance = SingletonTest7.getInstance();
        SingletonTest7 instance1 = SingletonTest7.getInstance();

        System.out.println(instance.equals(instance1));

        System.out.println(instance.hashCode() == instance1.hashCode());
    }
}

class SingletonTest7{

    private SingletonTest7(){}

    // 静态 内部类定义一个对象 INSTANCE
    private static class SingletonInner{
        private static final SingletonTest7 INSTANCE = new SingletonTest7();
    }

    // 调用静态内部类中的对象
    public static synchronized SingletonTest7 getInstance(){
        return SingletonInner.INSTANCE;
    }
}
