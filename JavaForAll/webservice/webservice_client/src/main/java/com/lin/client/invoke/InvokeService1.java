package com.lin.client.invoke;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * @program: webservice
 * @description: 代理类工厂的方法
 * @author: linsz
 * @create: 2022-09-18 12:04
 **/
public class InvokeService1 {

    public static void main(String[] args) {
        invokeService_2();
    }

    /**
     * 动态代理 调用server端的接口
     */
    public static void invokeService_2(){

        JaxWsDynamicClientFactory instance = JaxWsDynamicClientFactory.newInstance();
        Client client = instance.createClient("http://localhost:8888/services/ws/api?wsdl");

        try {
            Object[] objects = client.invoke("getInfo", "linsz");
            System.out.println("======>"+objects[0]);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
