package com.lin.singleton;

import java.util.Objects;

/**
 * @program: JavaForAll
 * @description: 懒汉式  线程不安全
 * @author: linsz
 * @create: 2022-11-15 17:58
 **/
public class LazyMan1 {

    public static void main(String[] args) {
        SingletonTest3 instance = SingletonTest3.getInstance();
        SingletonTest3 instance1 = SingletonTest3.getInstance();

        System.out.println(instance.equals(instance1));

        System.out.println(instance.hashCode() == instance1.hashCode());
    }

}
class SingletonTest3{

    private SingletonTest3(){}

    private static SingletonTest3 instance;

    /**
     *
     *  在饿汉式的前两种写法有一个弊端：我们会存在浪费内存的可能
     *  于是我们萌生了一种想法，如果它是空的，那么我们再去new
     *  但是这在高并发下存在不安全的可能
     * @return
     */
    public static SingletonTest3 getInstance(){
        if (Objects.isNull(instance)){
            instance = new SingletonTest3();
        }
        return instance;
    }


}
