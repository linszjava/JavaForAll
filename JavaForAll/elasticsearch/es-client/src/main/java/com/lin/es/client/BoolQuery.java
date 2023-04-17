package com.lin.es.client;

import com.lin.es.utils.ClientUtils;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * @program: es-client
 * @description: 全量查询
 * @author: linsz
 * @create: 2022-07-24 09:52
 **/
public class BoolQuery {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ClientUtils.getClient();

//        1.批量添加
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest("user").id("1").source(XContentType.JSON,"username","zhangsan","age",11))
                .add(new IndexRequest("user").id("2").source(XContentType.JSON,"username","lisi","age",22))
                .add(new IndexRequest("user").id("3").source(XContentType.JSON,"username","wangwu","age",22))
                .add(new IndexRequest("user").id("4").source(XContentType.JSON,"username","zhaoliu","age",44))
                .add(new IndexRequest("user").id("5").source(XContentType.JSON,"username","tianqi","age",55));

         client.bulk(bulkRequest, RequestOptions.DEFAULT);

//      3.bool查询
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user").source(new SearchSourceBuilder().query(QueryBuilders.boolQuery()
        .must(QueryBuilders.termQuery("age","22"))
        .must(QueryBuilders.prefixQuery("username","wang"))));
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            //把命中的记录以JSON转出
            System.out.println(hit.getSourceAsString());
        }
        System.out.println(response.getTook());

    }


}
