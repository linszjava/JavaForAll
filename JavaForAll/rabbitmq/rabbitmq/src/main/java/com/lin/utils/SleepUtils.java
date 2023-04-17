package com.lin.utils;

/**
 * @program: rabbitmq
 * @description: 睡眠工具类
 * @author: linsz
 * @create: 2022-07-12 05:27
 **/
public class SleepUtils {

    public static void sleep(int time) {
        try {
            Thread.sleep(1000 * time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
