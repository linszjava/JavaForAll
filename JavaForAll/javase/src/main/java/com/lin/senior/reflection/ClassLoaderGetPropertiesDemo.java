package com.lin.senior.reflection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program: javase
 * @description: 类加载器获取文件的属性测试
 * @author: linsz
 * @create: 2022-06-12 23:59
 **/
public class ClassLoaderGetPropertiesDemo {

    @Test
    public void test() {
        InputStream ins = null;
        try {
            ClassLoader classLoader = ClassLoaderGetPropertiesDemo.class.getClassLoader();
            ins = classLoader.getResourceAsStream("jdbc.properties");

            Properties properties = new Properties();
            properties.load(ins);

            String name = properties.getProperty("name");
            String age = properties.getProperty("age");
            System.out.println("name:" + name + ", age:" + age);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ins != null) {
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
