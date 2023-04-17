package com.lin.senior.io;

import org.junit.Test;

import java.io.File;

/**
 * @program: javase
 * @description: 文件的实例化
 * @author: linsz
 * @create: 2022-06-10 14:58
 **/
public class FileTestDemo {
    //   /Users/linsz/Documents/idea/Java/javase/src/main/resources/java.txt
    @Test
    public void testFile() {
        File file = new File("/Users/linsz/Documents/idea/Java/javase/src/main/resources/java.txt");


        File file1 = new File("/Users/linsz/Documents", "idea");

        File file2 = new File(file1, "/Java");

        File file3 = new File("java.txt");
        System.out.println(file);
        System.out.println(file1);
        System.out.println(file2);

        System.out.println(file.getName());
        System.out.println(file3.getAbsolutePath());
    }
}
