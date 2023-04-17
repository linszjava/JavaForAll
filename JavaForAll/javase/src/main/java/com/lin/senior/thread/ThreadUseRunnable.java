package com.lin.senior.thread;

/**
 * @program: javase
 * @description: 实现Runnable接口实现多线程
 * @author: linsz
 * @create: 2022-06-06 18:06
 **/
public class ThreadUseRunnable {
    public static void main(String[] args) {
        Window_ window = new Window_();

        Thread thread_1 = new Thread(window);
        Thread thread_2 = new Thread(window);
        Thread thread_3 = new Thread(window);

        thread_1.setName("线程1");
        thread_2.setName("线程2");
        thread_3.setName("线程3");

        thread_1.start();
        thread_2.start();
        thread_3.start();
    }

}

class Window_ implements Runnable {

    private int ticket = 100; //此处不必声明为static

    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "窗口："
                        + " 卖票 ：" + ticket--);
            } else break;
        }
    }
}
