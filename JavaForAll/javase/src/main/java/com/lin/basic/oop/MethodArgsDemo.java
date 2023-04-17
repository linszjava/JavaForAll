package com.lin.basic.oop;

/**
 * @program: Java
 * @description: 方法多参数测试
 * @author: linsz
 * @create: 2022-06-03 17:23
 **/
public class MethodArgsDemo {
    public static void main(String[] args) {
        MethodArgsDemo demo = new MethodArgsDemo();
        demo.show("a", "b", "1", "4");
        demo.show(1, 3, 4, 2, 4);
    }

    /**
     * 1、方法多参数
     *
     * @param strs
     * @description String[] strs
     */
    public void show(String... strs) {
        System.out.println("我是方法多参数string的测试");
        //遍历
        for (String str : strs) {
            System.out.print(str + "\t");
        }
        System.out.println();
    }

    /**
     * 2、方法多参数重载也支持
     *
     * @param ints description int[] ints
     */
    public void show(int... ints) {
        System.out.println("我是方法多参数int类型测试");
        //遍历
        for (int anInt : ints) {
            System.out.print(anInt + "\t");
        }
        System.out.println();
    }

    /**
     * 3、注意：这个方法不可行，默认 可变形参的书写如 String...strs 与 String[] strs 相同
     */
//    public void show(String[] strings){
//    }

    /**
     * 注意：当形参的个数不知一个时，可变形参只能放最后,而且有且只能有一个
     *
     * @param i
     * @param strings
     */
    public void show(int i, String... strings) {

    }


}