package com.lin.basic.array;

import java.util.Arrays;
import java.util.List;

/**
 * @program: Java
 * @description: Arrays工具类的使用
 * @author: linsz
 * @create: 2022-06-02 23:30
 **/
public class ArraysDemo {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 4, 2, 5, 33};
        int[] ints1 = new int[]{1, 3, 3, 2, 5, 33};
        //1. Arrays.equals
        System.out.println(Arrays.equals(ints, ints1));
        //2. Arrays.binarySearch
        System.out.println(Arrays.binarySearch(ints, 2));
        //3.Arrays.fill  会覆盖原来数组的所有值
        Arrays.fill(ints1, 2);
        //4. Arrays.toString
        System.out.println(Arrays.toString(ints1));
        //5.Arrays.asList
        List<Integer> integers = Arrays.asList(1, 3, 4, 3);
        System.out.println(integers);
    }
}
