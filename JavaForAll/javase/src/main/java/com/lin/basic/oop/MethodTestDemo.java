package com.lin.basic.oop;

import java.util.Arrays;

/**
 * @program: Java
 * @description: 面试题：尝试编写method方法，使之返回a,b的值，
 * @author: linsz
 * @create: 2022-06-03 23:28
 **/
public class MethodTestDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        //让你写一个method方法，使得输出的结果为a = 100,b = 200
        //method(a,b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);

        int[] ints = new int[]{12, 3, 3, 34, 56, 77, 432};
        showArray(ints);
        System.out.println(Arrays.toString(ints));
    }

    private static void method(int a, int b) {
        a *= 10;
        b *= 20;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.exit(0);
    }

    /**
     * 每个下标都除以第一个元素
     *
     * @param arr
     */
    public static void showArray(int[] arr) {
        //1. 这种方式 能正常显示出结果，但是并没有把结果赋值给原来的数组
//        for (int i : arr) {
//            i = i / (arr[0]);
//            System.out.println(i);
//        }
        //以下这种方式会出错
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = arr[i]/arr[0];
//            System.out.println(arr[i]);
//        }
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = arr[i] / arr[0];

        }
    }
}
