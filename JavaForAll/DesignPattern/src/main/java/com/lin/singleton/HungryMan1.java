package com.lin.singleton;

/**
 * @program: JavaForAll
 * @description: 饿汉式 静态常量
 * @author: linsz
 * @desc 缺点： 如果该类自始至终没有被使用过，则浪费了内存
 * @create: 2022-11-15 17:21
 **/
public class HungryMan1 {
    public static void main(String[] args) {
        SingletonTest instance = SingletonTest.getInstance();
        SingletonTest instance1 = SingletonTest.getInstance();

        System.out.println(instance.equals(instance1)); // true

        System.out.println(instance.hashCode() == instance1.hashCode()); // true
    }
}

// 该类只允许生成一个实例
class SingletonTest{

    private SingletonTest(){}
    // 每次外部所取得的都是同一个 instance 在类装载的时候完成实例化
    private final static SingletonTest instance = new SingletonTest();

    // 必须加上 static 字样,否则外部无法得到该方法
    public static SingletonTest getInstance(){
        return instance;
    }

}
