package com.lin.basic.array;


/**
 * @program: Java
 * @description: 数组的复制与反转  查找(线性查找 二分查找）
 * @author: linsz
 * @create: 2022-06-02 18:57
 **/
public class ArrayCopyAndReverse {
    public static void main(String[] args) {
        String[] strs = new String[]{"A", "D", "E", "B", "F"};

        //1.数组的复制
        String[] str = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            str[i] = strs[i];
        }

        //2.数组的遍历
        for (String s : str) {
            System.out.print(s + "\t");
        }
        System.out.println();

        //3.数组的反转
        for (int i = 0; i < strs.length / 2; i++) {
            String temp;
            temp = strs[i];
            strs[i] = strs[strs.length - i - 1];
            strs[strs.length - i - 1] = temp;
        }
        for (String s : strs) {
            System.out.print(s + "\t");
        }
        System.out.println();

        //4. 线性查找
        boolean isFlag = true;
        String dest = "D";
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(dest)) {
                System.out.println("查找成功，位置为索引下标：" + i);
                isFlag = false;
                break;
            }
        }
        if (isFlag) {
            System.out.println("查找失败");
        }
        //5. 二分查找
        int[] ints = new int[]{-4, -3, 4, 6, 7, 10, 33, 44, 66, 88};
        int obj = 88;
        int head = 0;
        int end = ints.length - 1;
        boolean isFind = true;
        while (head <= end) {
            int middle = (head + end) / 2;
            if (obj == ints[middle]) {
                System.out.println("查找成功，位置为" + middle);
                isFind = false;
                break;
            } else if (obj > ints[middle]) {
                //右半区
                head = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        if (isFind) {
            System.out.println("查找失败");
        }
    }
}
