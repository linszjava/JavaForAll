package com.lin.senior.date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @program: javase
 * @description: DateTimeFormat 使用
 * @author: linsz
 * @create: 2022-06-08 01:49
 **/
public class DateTimeFormatDemo {

    @Test
    public void testDateTimeFormat() {
        //1. 方式1 DateTimeFormatter.ISO_LOCAL_DATE_TIME.format()
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));
        //2022-06-08T01:51:13.002
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2022-06-08T01:51:13.002"));
        //2. 方式2  DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format()
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(LocalDateTime.now()));

        //3. 方式3 DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format()  常用
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));


    }
}
