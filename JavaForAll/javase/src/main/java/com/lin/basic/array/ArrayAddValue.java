package com.lin.basic.array;

/**
 * @program: Java
 * @description: 数组赋值求最大 最小值 求和 平均值
 * @author: linsz
 * @create: 2022-06-02 18:32
 **/
public class ArrayAddValue {
    public static void main(String[] args) {
        int[] arr = new int[10];
        //1.初始化赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (99 - 10 + 1) + 10);
        }
        //2.遍历
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        //3.求和
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println("总和为：" + sum);

        //4.求最大值
        int maxValue = arr[0];
        for (int i : arr) {
            if (i > maxValue) maxValue = i;
        }
        System.out.println("最大值为：" + maxValue);

        //5.求最小值
        int minValue = arr[0];
        for (int i : arr) {
            if (i < minValue) minValue = i;
        }
        System.out.println("最小值为：" + minValue);

        //6.平均值
        int ave = sum / arr.length;
        System.out.println("平均值为：" + ave);
    }
}
