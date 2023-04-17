package com.lin.senior.socket;

import org.junit.Test;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;

/**
 * @program: javase
 * @description: 网络编程 TCP
 * @author: linsz
 * @create: 2022-06-12 17:06
 **/
public class TCPSocketDemo {

    @Test
    public void testClient() {

        Socket socket = null;
        OutputStream socketOutputStream = null;
        try {
            socket = new Socket(Inet4Address.getByName("127.0.0.1"), 8888);

            socketOutputStream = socket.getOutputStream();

            socketOutputStream.write("你好啊服务器".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socketOutputStream != null) {
                try {
                    socketOutputStream.close();
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
        ServerSocket serverSocket = null;
        Socket socketAccept = null;
        InputStream inputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            serverSocket = new ServerSocket(8888);

            socketAccept = serverSocket.accept();

            inputStream = socketAccept.getInputStream();

            byte[] bytes = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            System.out.println(byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
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
            if (socketAccept != null) {
                try {
                    socketAccept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
