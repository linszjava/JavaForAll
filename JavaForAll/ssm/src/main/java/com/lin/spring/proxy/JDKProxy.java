package com.lin.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: JavaForAll
 * @description: 动态代理的实现 探究AOP的底层实现
 * @author: linsz
 * @create: 2022-06-24 06:42
 **/
public class JDKProxy {

    public static void main(String[] args) {
        Class<?>[] interfaces = {MathInterface.class};
        MathInterface instance = (MathInterface) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),
                interfaces, new MathProxy(new Math1()));

        System.out.println(instance.add(2, 5));
    }

}

interface MathInterface {

    int add(int a, int b);

    int update(String string);
}

class Math1 implements MathInterface {
    @Override
    public int add(int a, int b) {
        System.out.println("math中的add方法被执行了");
        return a + b;
    }

    @Override
    public int update(String string) {
        System.out.println("math中的update方法被执行了");
        return Integer.parseInt(string);
    }
}

class MathProxy implements InvocationHandler {

    private Object object;

    public MathProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //1. 方法执行之前
        System.out.println("被执行的方法名：" + method.getName() + "参数：" + args.toString());

        //2. 方法执行
        Object result = method.invoke(object, args);


        //3. 方法执行之后

        System.out.println("方法执行之后的一些操作...");

        return result;
    }
}


