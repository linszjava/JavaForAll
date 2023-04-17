package com.lin.senior.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @program: javase
 * @description: 转换流
 * @author: linsz
 * @create: 2022-06-11 12:43
 **/
public class InputStreamReaderAndOutputStreamWriterDemo {

    @Test
    //转换流 不会出错
    public void testInputStreamReader() {
        InputStreamReader inputStreamReader = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("br.txt");
            inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("utf-8"));
            //inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8"); //也行

            int len;
            char[] chars = new char[5];
            while ((len = inputStreamReader.read(chars)) != -1) {
                System.out.print(new String(chars, 0, len));
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    // 字节流
    public void FileInputStream() {
        //测试 如果我不使用转换流输出一个带中文的文本测试  byte[]不给太大 会出现乱码
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("br.txt");

            byte[] bytes = new byte[5];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
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

    @Test
    //字符流 输出中文不会出错
    public void testFileReader() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("br.txt");
            char[] chars = new char[5];
            int len;
            while ((len = fileReader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void testInputStreamReaderAndOutputStreamWriter() {
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream("f_utf_8.txt"), Charset.forName("utf-8"));
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream("f_gbk.txt"), Charset.forName("gbk"));

            char[] chars = new char[5];
            int len;
            while ((len = inputStreamReader.read(chars)) != -1) {
                outputStreamWriter.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
