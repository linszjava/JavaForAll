package com.lin.designpatter.proxy;

/**
 * @program: javase
 * @description: 代理模式：1.静态代理
 * @author: linsz
 * @create: 2022-06-05 23:13
 **/
public class StaticProxyDemo {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.run();
    }

}

interface Network {
    public void run();
}

class Server implements Network {

    public void run() {
        System.out.println("服务器已经连上网了");
    }
}

class ProxyServer implements Network {

    private Network network;

    public ProxyServer(Network network) {
        this.network = network;
    }

    public void beforeRun() {
        System.out.println("在联网之前的一些操作");
    }

    public void run() {
        beforeRun();
        network.run();

    }
}
