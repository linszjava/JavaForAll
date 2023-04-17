package com.lin.senior.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @program: javase
 * @description: String与Char[]、Byte[] 相互转化
 * @author: linsz
 * @create: 2022-06-07 16:34
 **/
public class StringToCharArrayAndToByteArrayDemo {

    @Test
    public void testStringToCharArray() {

        //1. String --> Char[]
        String str = "asgd124你好";
        char[] chars = str.toCharArray();
        System.out.println(chars);
        for (char aChar : chars) {
            System.out.println(aChar);
        }

        //2. char[] -->String
        char[] chs = new char[]{'a', 'c', 'd', 'f', '1', '4', '中'};
        String s = new String(chs);
        System.out.println(s);

    }

    @Test
    public void testStringToByteArray() throws UnsupportedEncodingException {
        String str = "Java世界123";
        byte[] bytes = str.getBytes();
        for (byte aByte : bytes) {
            System.out.print(aByte + " ");
        }
        System.out.println();

        String gbk = new String(bytes, "utf8");
        System.out.println(gbk);
    }
}

