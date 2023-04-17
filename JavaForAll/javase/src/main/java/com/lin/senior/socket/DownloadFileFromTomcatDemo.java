package com.lin.senior.socket;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @program: javase
 * @description: 从tomcat服务器下载文件
 * @author: linsz
 * @create: 2022-06-12 19:52
 **/
public class DownloadFileFromTomcatDemo {

    public static void main(String[] args) {
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("http://localhost:8080/examples/my/sky-1.png");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            fileOutputStream = new FileOutputStream("sky-2.png");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
            System.out.println("下载成功！！！！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }


//    public static void main(String[] args) {
//
//        HttpURLConnection urlConnection = null;
//        InputStream is = null;
//        FileOutputStream fos = null;
//        try {
//            URL url = new URL("http://localhost:8080/examples/my/sky-1.png");
//
//            urlConnection = (HttpURLConnection) url.openConnection();
//
//            urlConnection.connect();
//
//            is = urlConnection.getInputStream();
//            fos = new FileOutputStream("sky-3.png");
//
//            byte[] buffer = new byte[1024];
//            int len;
//            while((len = is.read(buffer)) != -1){
//                fos.write(buffer,0,len);
//            }
//
//            System.out.println("下载完成");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            //关闭资源
//            if(is != null){
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(fos != null){
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(urlConnection != null){
//                urlConnection.disconnect();
//            }
//        }
//
//
//
//
//
//
//    }
}
