package com.lin.senior.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @program: javase
 * @description: 节点流 文件流
 * @author: linsz
 * @create: 2022-06-10 22:52
 **/
public class FileInputStreamDemo {

    @Test
    public void testFileInputStream() {

        File file = new File("test.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            if (fileInputStream == null) {
                throw new RuntimeException("文件流不存在");
            }
            int data;
            while ((data = fileInputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
