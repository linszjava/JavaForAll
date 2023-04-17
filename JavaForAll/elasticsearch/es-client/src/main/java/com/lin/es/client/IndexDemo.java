package com.lin.es.client;

import com.lin.es.utils.ClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetadata;

import java.io.IOException;
import java.util.Map;

/**
 * @program: elasticsearch
 * @description: 客户端测试 : 创建一个index 索引
 * @author: linsz
 * @create: 2022-07-24 04:25
 **/
public class IndexDemo {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ClientUtils.getClient();
        //增加索引
//        CreateIndexResponse user = client.indices().create(new CreateIndexRequest("user"), RequestOptions.DEFAULT);
//        System.out.println(user.isAcknowledged());
        //查看索引
        GetIndexResponse user = client.indices().get(new GetIndexRequest("user"), RequestOptions.DEFAULT);
        Map<String, MappingMetadata> mappings = user.getMappings();
        for (Map.Entry<String, MappingMetadata> entry : mappings.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
//        user.getAliases().forEach((s, aliasMetadata) -> System.out.println(s+"::"+aliasMetadata));


//        ClientUtils.closeClient();


    }
}
