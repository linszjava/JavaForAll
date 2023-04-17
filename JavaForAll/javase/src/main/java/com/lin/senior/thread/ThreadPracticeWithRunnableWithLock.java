package com.lin.senior.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: javase
 * @description: 线程同步 使用Lock方式解决线程安全问题
 * @author: linsz
 * @create: 2022-06-06 23:03
 **/
public class ThreadPracticeWithRunnableWithLock {

    public static void main(String[] args) {
        Win win = new Win();

        Thread thread_1 = new Thread(win);
        Thread thread_2 = new Thread(win);

        thread_1.setName("线程1");
        thread_2.setName("线程2");

        thread_1.start();
        thread_2.start();

    }
}

class Win implements Runnable {

    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock(true);

    public void run() {
        while (true) {
            lock.lock();  //1. 手动加锁
            try {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName()
                            + ":售票第" + (ticket--) + "张");
                } else break;
            } finally {
                lock.unlock();
            }

        }
    }
}
