package com.lin.basic.array;

/**
 * @program: Java
 * @description: 冒泡排序算法
 * @author: linsz
 * @create: 2022-06-02 22:03
 **/
public class SortDemo {
    public static void main(String[] args) {
        int[] ints = new int[]{3, 10, 5, 2, 13, 44, -9};
        show(ints);
        Bobble(ints);
        show(ints);


    }

    public static void show(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    /**
     * 冒泡排序
     */
    public static void Bobble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { //趟数
            for (int j = 0; j < arr.length - 1 - i; j++) {  //比较的次数
                int temp;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }
}
