package com.lin.basic.oop;

import org.junit.Test;

/**
 * @program: Java
 * @description: 包装类 基本数据类型 String 三者的使用与相互转换
 * @author: linsz
 * @create: 2022-06-04 23:28
 **/
public class WrapperDemo {

    @Test
    /**
     * 1.包装类 --》 基本数据类型
     */
    public void test1() {
        Integer integer = new Integer(12);
        System.out.println(integer);
        System.out.println(integer.toString());
        System.out.println(integer.intValue());
        //包装类 --》基本数据类型   integer.xxxValue()
        int i = integer.intValue();
    }

    @Test
    /**
     * 2.基本数据类型转换为包装类
     */
    public void test2() {
        int i = 2;
        Integer integer = Integer.valueOf(i);
        System.out.println(integer);

    }

    @Test
    /**
     * 3. 基本数据类型转化为 String 类型
     */
    public void test3() {
        int i = 3;
        String s = String.valueOf(i);
        System.out.println(s);
    }

    @Test
    /**
     * 4.String 转换为 基本基本数据类型
     */
    public void test4() {

        String s = "123";
        int i = Integer.parseInt(s);
        System.out.println(i);

    }

    @Test
    /**
     * 5.String 转换为 包装类
     */
    public void test5() {
        String str = "true";
        boolean b = Boolean.parseBoolean(str);
        System.out.println(b);

    }

    @Test
    /**
     * 6. 包装类转化为String
     */
    public void test6() {
        Double aDouble = new Double(12.43);
        String s = aDouble.toString();
        System.out.println(s);
        System.out.println(s instanceof String);
    }

    @Test
    /**
     * 7. 自动装箱与拆箱
     */
    public void test7() {
        //s – the String to be converted to an Integer.
        Integer integer = new Integer("1234");
        System.out.println(integer);
        method("222");  //222 不会报错 多态的使用
    }

    public void method(Object obj) {
        System.out.println(obj);
    }
}
