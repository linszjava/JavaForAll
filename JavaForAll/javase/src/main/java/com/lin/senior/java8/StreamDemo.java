package com.lin.senior.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @program: javase
 * @description: Stream 流的创建
 * @author: linsz
 * @create: 2022-06-14 02:29
 **/
public class StreamDemo {

    //1. 集合
    @Test
    public void testCreatedByCollection() {
        ArrayList<Integer> integers = new ArrayList<>();
        Stream<Integer> stream = integers.stream();
    }


    //2. 数组
    @Test
    public void testCreatedByArray() {
        int[] ints = new int[]{1, 3, 3, 2, 5, 3, 11, 44};
        IntStream stream = Arrays.stream(ints);

    }

    //调用Stream.of()
    @Test
    public void testCreatedByStream() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("first");
        strings.add("second");
        strings.add("third");
        strings.add("forth");
        strings.add("fifth");
        Stream<ArrayList<String>> stream = Stream.of(strings);
    }

    //4.无限流
    @Test
    public void testCreatedByWithoutLimit() {
        Stream.iterate(0, integer -> integer + 2).limit(10).forEach(System.out::println);

        Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);
    }

}
