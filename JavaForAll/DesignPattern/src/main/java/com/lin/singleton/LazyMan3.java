package com.lin.singleton;

import java.util.Objects;

/**
 * @program: JavaForAll
 * @description: 懒汉式  线程安全 同步代码块
 * @author: linsz
 * @create: 2022-11-15 17:58
 **/
public class LazyMan3 {

    public static void main(String[] args) {
        SingletonTest5 instance = SingletonTest5.getInstance();
        SingletonTest5 instance1 = SingletonTest5.getInstance();

        System.out.println(instance.equals(instance1));

        System.out.println(instance.hashCode() == instance1.hashCode());
    }

}

class SingletonTest5{

    private SingletonTest5(){}

    private static SingletonTest5 instance;

    public static SingletonTest5 getInstance(){
        if (Objects.isNull(instance)){
            synchronized (SingletonTest5.class){
                instance = new SingletonTest5();
            }
        }
        return instance;
    }


}
