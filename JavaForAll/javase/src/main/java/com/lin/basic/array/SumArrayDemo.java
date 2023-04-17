package com.lin.basic.array;

/**
 * @program: Java
 * @description: 二维数组求和
 * @author: linsz
 * @create: 2022-06-02 16:50
 **/
public class SumArrayDemo {
    public static void main(String[] args) {
        int sum = 0;
        int[][] ints = new int[][]{{3, 5, 8}, {12, 9}, {7, 0, 6, 4}};
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                sum += ints[i][j];
            }
        }
        System.out.println(sum);
        System.out.println(ints.length);
    }
}
