package com.lin.basic.array;

/**
 * @program: Java
 * @description: 数组测试
 * @author: linsz
 * @create: 2022-06-02 16:36
 **/
public class ArrayDemoTest {
    public static void main(String[] args) {
        int[] arr = new int[5];
        String[] strings = new String[4];
        double[] doubles = new double[10];
        System.out.println(arr[3]);  //默认为0
        System.out.println(strings[2]);  //默认为null
        System.out.println(doubles[2]);  //默认为0.0
    }
}
