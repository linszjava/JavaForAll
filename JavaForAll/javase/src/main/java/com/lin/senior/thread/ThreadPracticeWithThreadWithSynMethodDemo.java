package com.lin.senior.thread;

/**
 * @program: javase
 * @description: 多线程买票测试： Thread实现并且 使用 线程同步方法 解决线程安全
 * @author: linsz
 * @create: 2022-06-06 15:31
 **/
public class ThreadPracticeWithThreadWithSynMethodDemo {
    public static void main(String[] args) {

        MyWindow_2 win1 = new MyWindow_2();
        MyWindow_2 win2 = new MyWindow_2();
        MyWindow_2 win3 = new MyWindow_2();

        win1.setName("1");
        win2.setName("2");
        win3.setName("3");

        win1.start();
        win2.start();
        win3.start();
    }


}

class MyWindow_2 extends Thread {

    private static int ticket = 100;
    private static Object object = new Object();

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized static void show() {   //MyWindow_2.class
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "窗口，售卖第" + (ticket--) + "张票");
        }
    }
}
