package com.lin.senior.others;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @program: javase
 * @description: 其他的常用类   BigDecimal
 * @author: linsz
 * @create: 2022-06-08 03:06
 **/
public class BigDecimalDemo {

    @Test
    public void testBigDecimal() {
        double d = 10;
        d = d / 3;
        System.out.println(d);

        BigDecimal bigDecimal = new BigDecimal("10.0");
        System.out.println(bigDecimal.divide(new BigDecimal(3), 10, BigDecimal.ROUND_DOWN));
    }
}
