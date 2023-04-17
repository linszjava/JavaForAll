package com.lin.senior.collection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @program: javase
 * @description: Properties 类的使用
 * @author: linsz
 * @create: 2022-06-09 03:54
 **/
public class PropertiesDemo {

    @Test
    public void testProperties() {
        Properties properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/Users/linsz/Documents/idea/Java/javase/src/main/resources/jdbc.properties");
            properties.load(fis);
            String name = properties.getProperty("name");
            String age = properties.getProperty("age");
            System.out.println("name:" + name + "，age:" + age);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
