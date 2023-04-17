package com.lin.singleton;

import java.util.Objects;

/**
 * @program: JavaForAll
 * @description: 懒汉式  线程安全 双重检查 推荐使用
 * @author: linsz
 * @create: 2022-11-15 17:58
 **/
public class LazyMan4 {

    public static void main(String[] args) {
        SingletonTest6 instance = SingletonTest6.getInstance();
        SingletonTest6 instance1 = SingletonTest6.getInstance();

        System.out.println(instance.equals(instance1));

        System.out.println(instance.hashCode() == instance1.hashCode());
    }

}

class SingletonTest6{

    private SingletonTest6(){}

    private static volatile SingletonTest6 instance;

    public static SingletonTest6 getInstance(){
        if (Objects.isNull(instance)){
            synchronized (SingletonTest5.class){
                if (Objects.isNull(instance)){
                    instance = new SingletonTest6();
                }
            }

        }
        return instance;
    }


}
