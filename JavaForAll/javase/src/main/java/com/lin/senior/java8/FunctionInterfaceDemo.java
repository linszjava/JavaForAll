package com.lin.senior.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @program: javase
 * @description: 函数式接口 Java内置四大函数式接口
 * @author: linsz
 * @create: 2022-06-14 00:55
 **/
public class FunctionInterfaceDemo {

    @Test
    public void testFunctionInterface() {
//        getMoney(10000, new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                //System.out.println("收到的工资为10000"+s);
//            }
//        });

        getMoney(20000, s -> System.out.println("工资哈哈哈：" + s));

        List<Integer> integerList = Arrays.asList(11, 22, 3, 4, 6, 33, 10, 9);
        List<Integer> getNewList = showList(integerList, integer -> {
            if (integer <= 10) {
                return true;
            } else return false;
        });
        System.out.println(getNewList);

    }

    public static void getMoney(int money, Consumer<String> consumer) {
        consumer.accept("工资：" + money);
    }

    public static List<Integer> showList(List<Integer> list, Predicate<Integer> predicate) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (Integer lis : list) {
            if (predicate.test(lis)) {
                integers.add(lis);
            }
        }
        return integers;
    }
}
