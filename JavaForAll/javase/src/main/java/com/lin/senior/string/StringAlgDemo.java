package com.lin.senior.string;

import org.junit.Test;

/**
 * @program: javase
 * @description: 关于String类型的算法题
 * @author: linsz
 * @create: 2022-06-07 21:08
 **/
public class StringAlgDemo {

    /**
     * 写一个功能与StringBuffer.reverse()相同的的反转算法，但要求可以只反转中间的几位
     * 如  aabbccdd  可以反转成 aaccbbdd
     */
    public static void main(String[] args) {
        String str = "aabbccddeeffgg";
        //System.out.println(reverseWithCharArray(str, 2, 12));
        // System.out.println(reverseWithString(str, 2, 12));
        System.out.println(reverseWithStringBuilder(str, 2, 12));
    }

    //1. 方式一 转换成char[] 数组 下标对应的字符反转
    public static String reverseWithCharArray(String str, int startIndex, int endIndex) {

        char[] chars = str.toCharArray();
        for (int i = startIndex, j = endIndex - 1; i < j; i++, j--) {
            char temp;
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);

    }

    //2. 方式二 subString拼接字符串
    public static String reverseWithString(String str, int startIndex, int endIndex) {

        //1. head
        String headStr = str.substring(0, startIndex);
        //2.middle
        for (int i = endIndex; i > startIndex; i--) {
            headStr += str.charAt(i - 1);
        }
        //3.end
        String endStr = str.substring(endIndex);
        headStr += endStr;

        return headStr;

    }

    //3.使用StringBuilder
    public static String reverseWithStringBuilder(String str, int startIndex, int endIndex) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        stringBuilder.append(str.substring(0, startIndex));

        for (int i = endIndex; i > startIndex; i--) {
            stringBuilder.append(str.charAt(i - 1));
        }
        stringBuilder.append(str.substring(endIndex));

        return new String(stringBuilder);
    }


}
