package com.lin.senior.string;

import org.openjdk.jol.vm.VM;

/**
 * @program: javase
 * @description: String 赋值的考察
 * @author: linsz
 * @create: 2022-06-07 01:58
 **/
public class StringDemo {

    public static void main(String[] args) {
        String s = "good";
        char[] chars = {'a', 'b', 'c', 'd'};
        change(s, chars);
        System.out.println(s); //good  String 虽然在change()中传的是地址，但是String类型的不可变性，所以得到的还是原来的值
        System.out.println(chars); //zbcd change()传的是地址，则chars被修改了，那就是被修改了

        String s1 = "java";
        String s2 = "javaweb";
        String s3 = "web";
        String s4 = new String("java");
        String s5 = s1 + "web";
        String s6 = "java" + s3;
        String s7 = s5.intern();
        String s8 = s1 + s3;
        String s9 = s4.intern();
        String s10 = s8.intern();

        System.out.println(s1 == s4);// false  s1:方法区常量池  s4: 堆
        System.out.println(s2 == s8);// false  s2: 方法区常量池  s1 s3 当成变量，在堆中
        System.out.println(s2 == s5);// false  s2: 方法区常量池  s5 当成变量，在堆中
        System.out.println(s1 == s9);// true   s1:方法区常量池 s9： .intern()后会把该String实例放在常量池
        System.out.println(s6 == s8);// false  s6: 其中的s3当成变量，放在堆中 s8: 也在堆中，但二者的地址不同
        System.out.println(s4 == s8);// false  s4 != s8 都在堆中,但由于String的不可变性
        System.out.println(s4 == s10); //false  s4: 堆  s10: 方法区常量池
        System.out.println(s2 == s10); //true  均在方法区常量池

        System.out.println("-----------------");
        //导入 jol-core依赖 查看该string的内存地址
        System.out.println(VM.current().addressOf(s1));// 31854807720  s1 == s9
        System.out.println(VM.current().addressOf(s2));// 31855826032  s2 == s7
        System.out.println(VM.current().addressOf(s3));// 31855826088
        System.out.println(VM.current().addressOf(s4));// 31855826136  s4 != s8 都在堆中,但由于String的不可变性
        System.out.println(VM.current().addressOf(s5));// 31855826680
        System.out.println(VM.current().addressOf(s6));// 31855826808
        System.out.println(VM.current().addressOf(s7));// 31855826032
        System.out.println(VM.current().addressOf(s8));// 31855826936
        System.out.println(VM.current().addressOf(s9));// 31854807720

    }

    public static void change(String str, char[] chars) {
        str = "excellent";
        chars[0] = 'z';
    }
}
