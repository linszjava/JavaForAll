package com.lin.senior.date;

import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: javase
 * @description: Calendar 使用
 * @author: linsz
 * @create: 2022-06-08 00:08
 **/
public class CalendarDemo {
    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        //System.out.println(calendar.getTime());

        calendar.set(2022, 6, 11);
//        System.out.println(calendar.get(Calendar.DATE));
//        calendar.add(Calendar.DAY_OF_MONTH,2);
//        System.out.println(calendar.getTime());
//        calendar.clear();
        System.out.println(calendar.getFirstDayOfWeek());
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

    }
}
