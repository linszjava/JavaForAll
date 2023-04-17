package com.lin.senior.reflection;

import org.junit.Test;


/**
 * @program: javase
 * @description: 静态代理和动态代理的实现
 * @author: linsz
 * @create: 2022-06-13 18:26
 **/
public class StaticProxyDemo {
    @Test
    public void testStaticProxy() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.getInstance(new NikeFactory());
        proxyFactory.produceClothes();
    }


}

interface ProduceFactory {
    void produceClothes();
}

class NikeFactory implements ProduceFactory {
    @Override
    public void produceClothes() {
        System.out.println("nike 生产衣服");
    }
}

class ProxyFactory implements ProduceFactory {
    private ProduceFactory produceFactory;

    public void getInstance(ProduceFactory produceFactory) {
        this.produceFactory = produceFactory;
    }

    @Override
    public void produceClothes() {
        System.out.println("代理工厂做的一些前置处理");
        produceFactory.produceClothes();
        System.out.println("代理工厂做的一些后续处理");
    }
}