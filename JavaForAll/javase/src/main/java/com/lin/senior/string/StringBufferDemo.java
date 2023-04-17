package com.lin.senior.string;

import org.junit.Test;
import org.openjdk.jol.vm.VM;

/**
 * @program: javase
 * @description: StringBuffer API 使用
 * @author: linsz
 * @create: 2022-06-07 17:16
 **/
public class StringBufferDemo {

    @Test
    public void testStringBufferAPI() {
        StringBuffer sb = new StringBuffer();
        System.out.println(VM.current().addressOf(sb));  //31863305680 地址不变
        StringBuffer append = sb.append("aa").append("bb");
        System.out.println(append);
        System.out.println(VM.current().addressOf(append)); //31863305680
        System.out.println(sb);
        /**
         * @Override
         *     public synchronized StringBuffer append(String str) {
         *         toStringCache = null;
         *         super.append(str);
         *         return this;
         *     }
         *     从StringBuffer的源码可见，在append方法后面返回的是this,支持链式调用
         */

        System.out.println("---------------------");
        System.out.println(sb.delete(0, 1));
        System.out.println(sb.capacity());
        System.out.println(sb.length());
        System.out.println(sb.append("ccddeeffgghhiijjkkllmmnnooppqqrrsstt"));
        System.out.println(sb.length());
        System.out.println(sb.capacity());
    }

    @Test
    public void testStringBuffer() {
        StringBuffer sb = new StringBuffer("aabbccdd");
        System.out.println(sb.insert(2, "zz"));
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        System.out.println("---------");

        System.out.println(sb.replace(1, sb.length(), ""));
        System.out.println(sb.length());
        System.out.println(sb.capacity());

        System.out.println(sb.append("ccdd").reverse());
        System.out.println(sb);
    }
}
