package com.lin.basic.flow_control;

import java.util.Scanner;

/**
 * @program: Java
 * @description: if-else 练习
 * @author: linsz
 * @create: 2022-06-02 13:37
 **/
public class IfDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        if (i == 100) {
            System.out.println("BWM");
        } else if (i > 80 && i <= 99) {
            System.out.println("iphone 13");
        } else if (i >= 60 && i <= 80) {
            System.out.println("ipad");
        } else {
            System.out.println("你不配");
        }
    }
}
