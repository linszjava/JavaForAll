package com.lin.senior.io;

import org.junit.Test;

import java.io.File;
import java.net.URI;

/**
 * @program: javase
 * @description: File 常用API 测试
 * @author: linsz
 * @create: 2022-06-10 17:07
 **/
public class FileAPIDemo {

    @Test
    public void testFileAPI() {
        File file = new File("test.txt");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        String parent = file.getParent();
        System.out.println(parent);
        File parentFile = file.getParentFile();
        System.out.println(parentFile);
        System.out.println(file.length());
        URI uri = file.toURI();
        System.out.println(uri);
        File file1 = new File("/Users/linsz/Documents/idea");

        System.out.println("--------------");


        File[] files = file1.listFiles();
        for (File f : files) {
            System.out.println(f);
        }

        System.out.println("========");

        String[] list = file1.list();
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("============");


    }

    @Test
    public void testRenameTo() {
        File file = new File("/Users/linsz/Documents/idea/test.txt"); //写绝对路径
        System.out.println(file.renameTo(new File("/Users/linsz/Documents/idea/renameDest/my.txt")));
    }

    @Test
    public void testFileISAPI() {
        File file = new File("src/main/resources/test.txt"); //mac 要这么写（？）
        File file1 = new File("test.txt");
        System.out.println(file.exists());
        System.out.println(file1.exists());
        System.out.println(file.isFile());
        System.out.println(file.isAbsolute());
        System.out.println(file.isHidden());
        System.out.println(file.isDirectory());
    }

    @Test
    public void testDir() {

        File file1 = new File("src/main/resources/java2/test-mkdir");
        boolean mkdir = file1.mkdir();
        System.out.println(mkdir);

        File file = new File("src/main/resources/java/test-mkdirs");
        System.out.println(file.mkdirs());
    }

}
