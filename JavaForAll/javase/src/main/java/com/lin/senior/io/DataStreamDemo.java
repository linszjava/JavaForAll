package com.lin.senior.io;

import org.junit.Test;

import java.io.*;

/**
 * @program: javase
 * @description: 数据流
 * @author: linsz
 * @create: 2022-06-11 20:01
 **/
public class DataStreamDemo {

    @Test
    public void testDataInputStreamAndDataOutputStream() {
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream("data.txt"));

            String name = dataInputStream.readUTF();
            int age = dataInputStream.readInt();
            boolean readBoolean = dataInputStream.readBoolean();

            System.out.println("name:" + name);
            System.out.println("age:" + age);
            System.out.println("readBoolean:" + readBoolean);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testDataOutPutStream() {
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream("data.txt"));

            dataOutputStream.writeUTF("林谦");
            dataOutputStream.writeInt(23);
            dataOutputStream.writeBoolean(true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
