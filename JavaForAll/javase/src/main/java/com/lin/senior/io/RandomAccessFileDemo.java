package com.lin.senior.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * @program: javase
 * @description: 随机访问文件流
 * @author: linsz
 * @create: 2022-06-12 08:40
 **/
public class RandomAccessFileDemo {

    @Test
    public void testRandomAccessFile() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile("data.txt", "rw");
            raf2 = new RandomAccessFile("data2.txt", "rw");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = raf1.read(bytes)) != -1) {
                raf2.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void testRandomAccessFileWithSeek() {

        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("data.txt", "rw");
            randomAccessFile.seek(4);
            byte[] bytes = new byte[1024];
            StringBuffer stringBuffer = new StringBuffer((int) new File("data.txt").length());
            int len;
            //String s = randomAccessFile.readLine();
            while ((len = randomAccessFile.read(bytes)) != -1) {
                stringBuffer.append(new String(bytes, 0, len));
            }

            randomAccessFile.seek(4);
            randomAccessFile.write("linsz".getBytes());
            System.out.println(stringBuffer);
            randomAccessFile.write(stringBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    @Test
    public void test3() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("data.txt", "rw");

        raf1.seek(3);//将指针调到角标为3的位置
        //保存指针3后面的所有数据到StringBuilder中
        StringBuilder builder = new StringBuilder((int) new File("data.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1) {
            builder.append(new String(buffer, 0, len));
        }
        //调回指针，写入“xyz”
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        //将StringBuilder中的数据写入到文件中
        raf1.write(builder.toString().getBytes());

        raf1.close();

        //思考：将StringBuilder替换为ByteArrayOutputStream
    }
}
