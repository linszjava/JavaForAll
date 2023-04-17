package com.lin.senior.java8;

import org.junit.Test;

import java.awt.*;
import java.util.function.Consumer;

/**
 * @program: javase
 * @description: Lambda表达式的使用
 * @author: linsz
 * @create: 2022-06-14 00:21
 **/
public class LambdaDemo {

    @Test
    public void testLambda() {
        //1. 无参直接输出
        Runnable runnable = () -> System.out.println("这是一个lambda表达式");
        runnable.run();

        //2. 一个参数 省略参数类型
        Consumer<String> stringConsumer = (o1) -> System.out.println("这是啥？");

        //3. 一个参数  省略括号
        Comparable<Integer> comparable = o -> o.compareTo(o);

        //4. 多句语句用括号包起来
        Consumer<String> consumer = (s) -> {
            System.out.println("before");
            System.out.println(s);
            System.out.println("after");
        };


    }


}
