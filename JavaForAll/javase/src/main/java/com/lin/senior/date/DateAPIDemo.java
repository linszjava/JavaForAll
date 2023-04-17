package com.lin.senior.date;

import org.junit.Test;

import java.util.Date;

/**
 * @program: javase
 * @description: Date API 测试
 * @author: linsz
 * @create: 2022-06-07 18:39
 **/
public class DateAPIDemo {

    /**
     * java.util.Date
     */
    @Test
    public void testJavaUtilDate() {
        Date date = new Date();
        System.out.println(date);
        long time = date.getTime();
        System.out.println(time);

        System.out.println("-----------");
        Date date1 = new Date(1224330045l);
        System.out.println(date1);
    }

    @Test
    public void testJavaSqlDate() {
        java.sql.Date date = new java.sql.Date(1224330045l); //before
        java.sql.Date date2 = new java.sql.Date(1224330049l); //after
        System.out.println(date);
        System.out.println(date.before(date2)); //true
    }

    @Test
    public void testSystemCurrentTimeMillis() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testJavaSqlDateAndJavaUtilDateTransfer() {
        Date utilDate = new Date(1224330045l);  //java.util.Date
        java.sql.Date sqlDate = new java.sql.Date(1224330049l);
        System.out.println(utilDate);
        System.out.println(sqlDate);
        Date toUtilDate = sqlDate;  //子转父  public class java.sql.Date extends java.util.Date
        System.out.println(toUtilDate);
        java.sql.Date toSqlDate = (java.sql.Date) utilDate;
        System.out.println(toSqlDate); //java.lang.ClassCastException: java.util.Date cannot be cast to java.sql.Date

    }
}
