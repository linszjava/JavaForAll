package com.lin.singleton;

/**
 * @program: JavaForAll
 * @description: 使用枚举实现单例 推荐
 * @author: linsz
 * @create: 2022-11-15 22:30
 **/
public class Singleton8 {

    public static void main(String[] args) {
        SingletonTest8 instance = SingletonTest8.INSTANCE;
        SingletonTest8 instance1 = SingletonTest8.INSTANCE;

        System.out.println(instance.equals(instance1));

        instance.testOK();
        instance1.testOK();
    }

}

enum SingletonTest8{
    INSTANCE;

    public void testOK(){
        System.out.println("it's ok");
    }
}
