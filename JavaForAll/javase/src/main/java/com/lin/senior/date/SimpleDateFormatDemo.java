package com.lin.senior.date;

import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: javase
 * @description: SimpleDateFormat 的测试类
 * @author: linsz
 * @create: 2022-06-07 23:29
 **/
public class SimpleDateFormatDemo {

    @Test
    public void testSimpleDateFormat() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date()));
        System.out.println(DateUtil.now());  //hutool工具包
    }
}
