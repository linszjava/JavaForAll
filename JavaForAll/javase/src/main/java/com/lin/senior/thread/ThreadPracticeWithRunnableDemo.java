package com.lin.senior.thread;

/**
 * @program: javase
 * @description: 实现Runnable 接口的多线程 ，并且解决线程安全问题
 * @author: linsz
 * @create: 2022-06-06 21:35
 **/
public class ThreadPracticeWithRunnableDemo {
    public static void main(String[] args) {
        MyWindow myWindow = new MyWindow();

        Thread thread_1 = new Thread(myWindow);
        Thread thread_2 = new Thread(myWindow);
        Thread thread_3 = new Thread(myWindow);

        thread_1.setName("线程1");
        thread_2.setName("线程2");
        thread_3.setName("线程3");

        thread_1.start();
        thread_2.start();
        thread_3.start();
    }

}

class MyWindow implements Runnable {
    private int ticket = 100;
    private Object object = new Object();

    public void run() {
        while (true) {
//            synchronized (this){       //1. 写法1
            synchronized (object) {   //2. 写法2
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() +
                            ": 售卖第" + (ticket--) + "张票");
                }
            }
        }
    }
}
