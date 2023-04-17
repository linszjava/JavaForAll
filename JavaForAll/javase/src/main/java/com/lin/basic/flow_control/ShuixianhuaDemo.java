package com.lin.basic.flow_control;

/**
 * @program: Java
 * @description: 水仙花数测试 所谓水仙花数是指一个3位数，其各个位上数 字立方和等于其本身。
 * @author: linsz
 * @create: 2022-06-02 13:53
 **/
public class ShuixianhuaDemo {
    public static void main(String[] args) {
        int g, s, b;
        for (int i = 100; i < 999; i++) {
            g = i % 10;
            s = i / 10 % 10;
            b = i / 100;
            if (i == (g * g * g + s * s * s + b * b * b)) {
                System.out.println(i);
            }

        }
    }
}
