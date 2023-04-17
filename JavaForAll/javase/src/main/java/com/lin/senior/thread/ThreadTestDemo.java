package com.lin.senior.thread;

/**
 * @program: javase
 * @description: 多线程的使用 1：继承Thread类
 * @author: linsz
 * @create: 2022-06-06 05:59
 * @methods: 线程的常用方法
 * 1.run();
 * 2.start();  new Thread().start(); 默认会调用Thread类中的run()方法
 * 3.currentThread 表示当前的线程  Thread.currentThread
 * 4.setName();
 * 5.getName();
 * 6.yield();  屈服 直接调用该方法即可，会阻塞当前线程，让其他线程进入
 * 7.join();  myThread.join();
 * 8.sleep();
 * 9.isAlive(); 判断该线程是否存活，调用方式：myThread.isAlive();
 **/
public class ThreadTestDemo {
    public static void main(String[] args) {
        //4.使用new的实例对象调用start();
        MyThread myThread = new MyThread();
        myThread.setName("子线程-1");
        myThread.start();

        Thread.currentThread().setName("主线程-1");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
//                try {
//                    Thread.sleep(1000);  //如果i是整数 停一秒
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + " " + i + "     *********main********");
            }
            System.out.println(myThread.isAlive()); //判断该线程是否存活
            if (i == 30) {
                try {
                    myThread.join(); //没有其他的中断或者阻塞等，会让当前新加入的线程跑完
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}

/**
 * 1.定义一个类 并且继承Thread
 */
class MyThread extends Thread {
    /**
     * 2.重写里面的run()；
     */
    @Override
    public void run() {
        //3.实现具体的代码逻辑
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                //打印偶数
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            if (i == 20) {
                yield(); //屈服 让其他线程先跑
            }
        }
    }
}
