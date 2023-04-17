package com.lin.senior.thread;

/**
 * @program: javase
 * @description: 多线程买票测试： Thread实现并且解决线程安全
 * @author: linsz
 * @create: 2022-06-06 15:31
 **/
public class ThreadPracticeWithThreadDemo {
    public static void main(String[] args) {

        Window win1 = new Window();
        Window win2 = new Window();
        Window win3 = new Window();

        win1.setName("1");
        win2.setName("2");
        win3.setName("3");

        win1.start();
        win2.start();
        win3.start();
    }


}

class Window extends Thread {

    private static int ticket = 100;
    private static Object object = new Object();

    @Override
    public void run() {
        while (true) {
//            synchronized (Window.class){  //1. 同步监视器的写法一
            synchronized (object) {          //2. 同步监视器的写法二
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "窗口，售卖第" + (ticket--) + "张票");
                } else break;
            }
        }
    }
}
