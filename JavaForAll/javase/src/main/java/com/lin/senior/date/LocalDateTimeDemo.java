package com.lin.senior.date;

import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @program: javase
 * @description: LocalDate、LocalTime、LocalDateTime 的使用
 * @author: linsz
 * @create: 2022-06-08 00:56
 **/
public class LocalDateTimeDemo {

    @Test
    public void testLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getDayOfYear());

        System.out.println(now.getMonthValue());

        LocalDateTime last = LocalDateTime.of(2022, 12, 24, 8, 30, 0);
        System.out.println(last.minusDays(2));
    }
}
