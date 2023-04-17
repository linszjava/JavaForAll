package com.lin.es.utils;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @program: elasticsearch
 * @description: 客户端连接的工具类
 * @author: linsz
 * @create: 2022-07-24 04:16
 **/
public class ClientUtils {

    public static RestHighLevelClient getClient(){
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200))
        );
        return client;
    }

    public static void closeClient(){
        try {
            getClient().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
