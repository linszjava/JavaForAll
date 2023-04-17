package com.lin.senior.socket;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: javase
 * @description: 传输文件的Socket  对传输完成的文件向客户端反馈信息
 * 注意：在client传完 图片时 就应该要关闭 socket.shutdownOutputStream();
 * @author: linsz
 * @create: 2022-06-12 17:41
 **/
public class TcpSocketDemo3 {

    @Test
    public void testClient() {

        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            socket = new Socket("127.0.0.1", 8888);

            outputStream = socket.getOutputStream();

            fileInputStream = new FileInputStream("1.jpeg");

            byte[] bytes = new byte[1024];
            int len;

            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            socket.shutdownOutput();

            inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes1 = new byte[1024];
            int len1;
            while ((len1 = inputStream.read(bytes1)) != -1) {
                byteArrayOutputStream.write(bytes1, 0, len1);
            }
            System.out.println(byteArrayOutputStream.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testServerSocket() {
        Socket socket = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        OutputStream outputStream = null;
        try {
            socket = new ServerSocket(8888).accept();

            inputStream = socket.getInputStream();

            fileOutputStream = new FileOutputStream("2_img.jpeg");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
            // 对于传输完成后 向客户端反馈信息 先测一下
            outputStream = socket.getOutputStream();
            outputStream.write("文件传输完成，不错".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
