package com.lin.senior.reflection;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: javase
 * @description: 动态代理
 * 意义：在运行的时候再决定我动态代理哪一个类，而不是在编译的时候就决定
 * @author: linsz
 * @create: 2022-06-13 20:46
 **/
public class DynamicProxyDemo {

    @Test
    public void testDynamicProxy() {
        SuperMan superMan = new SuperMan();
        HumanInterface instance = (HumanInterface) MyProxyFactory.getInstance(superMan);

        System.out.println(instance.showInfo());
        instance.eat();


    }

}

interface HumanInterface {

    String showInfo();

    void eat();
}

class SuperMan implements HumanInterface {

    public SuperMan() {

    }

    @Override
    public String showInfo() {
        return "我是超人";
    }

    @Override
    public void eat() {
        System.out.println("超人也吃饭");
    }
}

class MyProxyFactory {
    public static Object getInstance(Object o) {
        MyInvocationHandle myInvocationHandle = new MyInvocationHandle();
        myInvocationHandle.bind(o);
        return Proxy.newProxyInstance(o.getClass().getClassLoader(),
                o.getClass().getInterfaces(), myInvocationHandle);
    }
}

class MyInvocationHandle implements InvocationHandler {

    private Object object;

    public void bind(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        MyUtils.getMethodBefore();
        Object returnValue = method.invoke(object, args);
        MyUtils.getMethodAfter();

        return returnValue;
    }
}

class MyUtils {

    public static void getMethodBefore() {
        System.out.println("===========插入在前==========");
    }

    public static void getMethodAfter() {
        System.out.println("==========插入在后===========");

    }
}
