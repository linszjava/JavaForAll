package com.lin.designpatter.proxy;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @program: javase
 * @description: 以明星为例的静态代理实现
 * @author: linsz
 * @create: 2022-06-05 23:26
 **/
public class StaticProxyDemoForStar {
    public static void main(String[] args) {
        RealStar realStar = new RealStar();
        Proxy proxy = new Proxy(realStar);
        proxy.confer();
        proxy.signContract();
        proxy.bookTickets();
        proxy.sing();
        proxy.collectMoney();

    }
}

interface Star {
    public abstract void confer(); //面谈

    void signContract(); //签合同

    void bookTickets(); //订票

    void sing(); //唱歌

    void collectMoney(); //收钱
}

class RealStar implements Star {
    public void confer() {

    }

    public void signContract() {

    }

    public void bookTickets() {

    }

    public void sing() {
        System.out.println("歌手唱歌----");
    }

    public void collectMoney() {

    }
}

class Proxy implements Star {

    //    private Star star;
    private RealStar realStar;

    public Proxy(RealStar realStar) {
        this.realStar = realStar;
    }
    //    public Proxy(Star star) {
//        this.star = star;
//
//    }

    public void confer() {
        System.out.println("经纪人面谈");
    }

    public void signContract() {
        System.out.println("经纪人签订合同");
    }

    public void bookTickets() {
        System.out.println("经纪人订票");
    }

    public void sing() {
        realStar.sing();
    }

    public void collectMoney() {
        System.out.println("经纪人收钱");
    }
}
