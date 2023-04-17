package com.lin.singleton;

import java.util.Objects;

/**
 * @program: JavaForAll
 * @description: 懒汉式  线程安全 同步方法 但是效率较低
 * @author: linsz
 * @create: 2022-11-15 18:13
 **/
public class LazyMan2 {

    public static void main(String[] args) {
        SingletonTest4 instance = SingletonTest4.getInstance();
        SingletonTest4 instance1 = SingletonTest4.getInstance();

        System.out.println(instance.equals(instance1));

        System.out.println(instance.hashCode() == instance1.hashCode());
    }

}

class SingletonTest4{

    private SingletonTest4(){}

    private static SingletonTest4 instance;

    /**
     * synchronized 同步方法
     * @return
     */
    public static synchronized SingletonTest4 getInstance(){
        if (Objects.isNull(instance)){
            instance = new SingletonTest4();
        }
        return instance;
    }


}
