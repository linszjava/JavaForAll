package com.lin.es.client;

import com.lin.es.utils.ClientUtils;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @program: elasticsearch
 * @description: index delete
 * @author: linsz
 * @create: 2022-07-24 05:30
 **/
public class IndexDeleteDemo {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ClientUtils.getClient();
        AcknowledgedResponse user = client.indices().delete(new DeleteIndexRequest("user"), RequestOptions.DEFAULT);
        System.out.println(user.isAcknowledged());
    }
}
