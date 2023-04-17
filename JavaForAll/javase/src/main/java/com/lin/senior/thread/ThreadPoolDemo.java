package com.lin.senior.thread;

import java.util.concurrent.*;

/**
 * @program: javase
 * @description: 创建线程方式4：线程池
 * @author: linsz
 * @create: 2022-06-07 00:54
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

//        service.execute(new ThreadNum());
//        service.execute(new ThreadNum());


        ThreadNum_2 threadNum_2 = new ThreadNum_2();
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(threadNum_2);
        service.submit(integerFutureTask);

        try {
            System.out.println(integerFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class ThreadNum implements Runnable {
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()
                        + "：" + i);
            }
        }
    }
}

class ThreadNum_2 implements Callable<Integer> {

    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
                System.out.println(Thread.currentThread().getName()
                        + "##  " + i);
            }
        }
        return sum;
    }
}
