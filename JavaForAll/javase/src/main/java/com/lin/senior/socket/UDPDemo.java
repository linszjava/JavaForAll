package com.lin.senior.socket;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;

/**
 * @program: javase
 * @description: UDP 测试
 * @author: linsz
 * @create: 2022-06-12 19:34
 **/
public class UDPDemo {

    @Test
    public void testSender() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            String str = "我是UDP测试";
            DatagramPacket datagramPacket =
                    new DatagramPacket(str.getBytes(), str.getBytes().length, Inet4Address.getLocalHost(), 9999);

            socket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

    @Test
    public void testReceiver() {

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9999);

            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            socket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            String str = new String(data, 0, data.length);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }

    }
}
