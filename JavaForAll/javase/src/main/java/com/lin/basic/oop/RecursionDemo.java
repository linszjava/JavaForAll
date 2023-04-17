package com.lin.basic.oop;

/**
 * @program: Java
 * @description: 递归循环测试
 * @author: linsz
 * @create: 2022-06-04 00:10
 **/
public class RecursionDemo {
    public static void main(String[] args) {
        System.out.println(getSumWithFor()); //5050
        System.out.println(getSumWithRecursion(100)); //5050
    }

    //1.计算1~100的和 for循环
    public static int getSumWithFor() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum = sum + i;
        }
        return sum;
    }

    //2. 递归实现
    public static int getSumWithRecursion(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + getSumWithRecursion(n - 1);
        }
    }
}
