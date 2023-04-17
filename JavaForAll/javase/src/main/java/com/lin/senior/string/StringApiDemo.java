package com.lin.senior.string;

import org.junit.Test;

/**
 * @program: javase
 * @description: String 常用API 使用
 * @author: linsz
 * @create: 2022-06-07 15:23
 **/
public class StringApiDemo {

    @Test
    public void test() {
        String str = "javaweb";

        String str2 = "   java  web    ";

        System.out.println(str.length());                            //7
        System.out.println(str.charAt(0));                           //j
        System.out.println(str.toString());                          //javaweb
        System.out.println(str.toUpperCase());                       //JAVAWEB
        System.out.println(str.toLowerCase());                       //javaweb
        System.out.println(str.contains("va"));                      //true
        System.out.println(str.concat("ssm"));                       // javawebssm
        System.out.println(str.substring(4));                        //web
        System.out.println(str.compareTo("javawec"));                // -1
        System.out.println(str2.trim());                             //掐头去尾不去中   java  web
        System.out.println(str2.trim().equals(str));                 //false
        System.out.println(str.toUpperCase().equalsIgnoreCase(str)); //true
    }

    @Test
    public void test2() {
        String s = "javawecdawebweewwe";

        System.out.println(s.startsWith("av"));  //false
        System.out.println(s.endsWith("eb"));    //true
        int a = s.indexOf("a");
        System.out.println(a);  //1
        System.out.println(s.indexOf("va", 3));
        int a1 = s.lastIndexOf("aw");  //last：最后一次，还是从左往右开始算
        System.out.println(a1);
        System.out.println(s.lastIndexOf("we"));  //16
        System.out.println(s.lastIndexOf("we", 5));  //4 从fromIndex开始反向搜索,反正都是从左往右，你就理解为只遍历到fromIndex
    }

}
