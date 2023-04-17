package com.lin.senior.java8;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @program: javase
 * @description: 筛选与切片
 * @author: linsz
 * @create: 2022-06-14 02:47
 **/
public class StreamAPIDemo {

    @Test
    public void testStream() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(1);
        integers.add(3);
        integers.add(5);
        integers.add(8);
        integers.add(11);
        integers.add(11);
        integers.add(11);

        integers.stream().filter(integer -> integer < 10).distinct().limit(30)
                .skip(2).forEach(System.out::println);
    }

    @Test
    public void testSteamAPIMap() {
        List<String> stringList = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        stringList.stream().flatMap(str -> toCharArray(str)).forEach(System.out::println);

    }

    public static Stream<Character> toCharArray(String str) {
        ArrayList<Character> strings = new ArrayList<>();
        for (char c : str.toCharArray()) {
            strings.add(c);
        }
        return strings.stream();
    }

    @Test
    public void testStreamAPI2() {
        List<Integer> integerList = Arrays.asList(1, -3, 44, 3, 55, 33, 11, 4, 66);
        //1.allMatch
        System.out.println(integerList.stream().allMatch(integer -> integer > 0));
        //2.count
        System.out.println(integerList.stream().count());
        //3. anyMatch
        System.out.println(integerList.stream().anyMatch(integer -> integer == 55));
        //4.  noneMatch
        System.out.println(integerList.stream().noneMatch(integer -> integer > 100));
        //5. sorted
        //integerList.stream().sorted().forEach(System.out::println);
        //6. sorted(Integer::compare)
        integerList.stream().sorted(Integer::compare).forEach(System.out::println);
        //7.findAny
        System.out.println(integerList.stream().findAny());
        //8.findFirst
        System.out.println(integerList.stream().sorted().findFirst());
        //9.max
        System.out.println(integerList.stream().max(Integer::compareTo));
        //10.min
        System.out.println(integerList.stream().min(Double::compare));

        //11. reduce  注：上面这个list 总和为214  第一个参数为累加器的初始值
        System.out.println(integerList.stream().reduce(10, Integer::sum));

        //求得8的阶层 40320
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(list.stream().reduce((e1, e2) -> e1 * e2));
    }

    @Test
    public void testFactorialByStream() {
        //目的： 使用stream 实现任意数正整数的阶乘
        //1. for循环
        System.out.println("--------for循环-------------");
        long start1 = System.currentTimeMillis();
        System.out.println(FactorialByForRecursion(10));
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);
        System.out.println("----------------------------");
        //2. 递归
        System.out.println("------递归----------------");
        long start2 = System.currentTimeMillis();
        System.out.println(FactorialByRecursion(10));
        long end2 = System.currentTimeMillis();
        System.out.println((end2 - start2));
        //3. 使用流
        System.out.println("------stream------------------");
        long start3 = System.currentTimeMillis();
        System.out.println(FactorialByStream(10).get());
        long end3 = System.currentTimeMillis();
        System.out.println(end3 - start3);
    }

    private static Optional<Integer> FactorialByStream(int num) {
        return Stream.iterate(1, integer -> integer + 1).limit(num)
                .reduce(((integer, integer2) -> integer * integer2));
    }

    private static long FactorialByForRecursion(int num) {
        long count = 1L;
        for (int i = 1; i <= num; i++) {
            count *= i;
        }
        return count;
    }

    private static long FactorialByRecursion(long num) {
        if (num < 1) return 1;
        return num * FactorialByRecursion(--num);
    }
}
