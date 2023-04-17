package com.lin.es.client;

import com.lin.es.utils.ClientUtils;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.Map;

/**
 * @program: es-client
 * @description: 批量处理
 * @author: linsz
 * @create: 2022-07-24 09:24
 **/
public class DocumentBatchDemo {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ClientUtils.getClient();

//        1.批量增加
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest("user").id("1").source(XContentType.JSON,"username","zhansan"))
                .add(new IndexRequest("user").id("2").source(XContentType.JSON,"username","lisi"))
                .add(new IndexRequest("user").id("3").source(XContentType.JSON,"username","wangwu"));

        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.getItems());

//        2.批量删除
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new DeleteRequest("user","2"))
                .add(new DeleteRequest("user","3"));

        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulkResponse);


    }
}
