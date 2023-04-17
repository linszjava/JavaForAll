package com.lin.dataStructure.queue;

/**
 * @program: DataStructureAndAlg
 * @description: 测试
 * @author: linsz
 * @create: 2022-10-09 19:18
 **/
public class MyTest {
    public static void main(String[] args) {
        int a=7;
        int b=6;
        int c= 10;
        c=a%b;
        System.out.println(c);
        a++;
        b--;
        c=++a + --b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
