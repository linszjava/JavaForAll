package com.lin.senior.io;

import java.io.*;

/**
 * @program: javase
 * @description: 其他流的使用 System.in
 * @author: linsz
 * @create: 2022-06-11 18:34
 **/
public class SystemInDemo {

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));


            while (true) {
                String str = bufferedReader.readLine();
                System.out.println(str);
                if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
