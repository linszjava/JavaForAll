package com.lin.senior.io;

import org.junit.Test;

import java.io.*;

/**
 * @program: javase
 * @description: FileReader and FileWriter
 * @author: linsz
 * @create: 2022-06-10 23:04
 **/
public class FileReaderAndWriterDemo {

    @Test
    public void testFileReader() throws FileNotFoundException {
        File file = new File("test.txt");
        FileReader fileReader = new FileReader(file);
        if (fileReader != null) {
            try {
                int data;
                while ((data = fileReader.read()) != -1) {
                    System.out.print((char) data);
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
        } else {
            throw new RuntimeException("文件流不存在");
        }

    }


    //2. 升级版的FileReader写法
    @Test
    public void testFileReader2() {
        File file = new File("test.txt");

        FileReader reader = null;
        try {
            reader = new FileReader(file);

            char[] chars = new char[5];
            int len;
            while ((len = reader.read(chars)) != -1) {
                String str = new String(chars, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testFileWriter() {
        //File file = new File("writer.txt");

        FileWriter fw = null;
        try {
            fw = new FileWriter("writer1.txt", false);

            fw.write("I am a good boy\n");
            fw.write("you are a bad guy\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void testFileWriterAndReader() {

        //1. 定义文件输入输出流
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("reader.txt");
            fileWriter = new FileWriter("writer.txt", true);

            //2. 读入 写出  目标：把reader.txt 的东西 全部写到 writer.txt
            char[] chars = new char[5];
            int len;
            while ((len = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //3. 关流
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
