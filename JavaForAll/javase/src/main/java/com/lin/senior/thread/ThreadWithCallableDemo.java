package com.lin.senior.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @program: javase
 * @description: 创建多线程的方式三：实现Callable接口
 * @author: linsz
 * @create: 2022-06-07 00:20
 **/
public class ThreadWithCallableDemo {
    public static void main(String[] args) {
        //3. 创建一个实现Callable接口的类实例对象
        MyCallable myCallable = new MyCallable();
        //4. 创建一个FutureTask()类对象
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(myCallable);
        //5. 把该futureTask实例放入Thread中
        Thread thread = new Thread(integerFutureTask);
        //6.执行start()方法
        thread.start();

        //7. 如果需要查看call函数的返回值，可以调用该方法 futureTask.get()；
        try {
            Integer sum = integerFutureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

//1. 实现callable接口
class MyCallable implements Callable<Integer> {

    //2. 实现call 方法，注意：有返回值
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}