package com.lin.senior.io;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import java.io.*;

/**
 * @program: javase
 * @description: 对象流 ObjectInputStream ObjectOutputStream
 * @author: linsz
 * @create: 2022-06-12 06:17
 **/
public class ObjectInputStreamAndOutputStream {

    @Test
    public void testObjectOutputStream() {

        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.dat"));

            objectOutputStream.writeObject("我爱Java大世界");
            objectOutputStream.flush();

            objectOutputStream.writeObject(new Person(12, "林谦", "厦门的大学"));
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    @Test
    public void testObjectInputStream() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("object.dat"));

            Object o = objectInputStream.readObject();
            System.out.println(o);

            System.out.println(objectInputStream.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
