package com.lin.es.client;

import com.lin.es.utils.ClientUtils;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;

import java.io.IOException;

/**
 * @program: es-client
 * @description: 聚合查询
 * @author: linsz
 * @create: 2022-07-24 09:52
 **/
public class AggsQuery {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ClientUtils.getClient();

//        1.批量添加
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest("user").id("1").source(XContentType.JSON,"username","zhangsan","age",11))
                .add(new IndexRequest("user").id("2").source(XContentType.JSON,"username","lisi","age",22))
                .add(new IndexRequest("user").id("3").source(XContentType.JSON,"username","lisi22","age",22))
                .add(new IndexRequest("user").id("4").source(XContentType.JSON,"username","zhaoliu","age",44))
                .add(new IndexRequest("user").id("5").source(XContentType.JSON,"username","tianqi","age",55));

         client.bulk(bulkRequest, RequestOptions.DEFAULT);

//      2.聚合查询
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user").source(new SearchSourceBuilder().aggregation(AggregationBuilders.terms("age_group").field("age")));
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            //把命中的记录以JSON转出
            System.out.println(hit.getSourceAsString());
        }
//        {"took":903,"timed_out":false,"_shards":{"total":1,"successful":1,"skipped":0,"failed":0},"hits":{"total":{"value":5,"relation":"eq"},"max_score":1.0,"hits":[{"_index":"user","_type":"_doc","_id":"1","_score":1.0,"_source":{"username":"zhangsan","age":11}},{"_index":"user","_type":"_doc","_id":"2","_score":1.0,"_source":{"username":"lisi","age":22}},{"_index":"user","_type":"_doc","_id":"3","_score":1.0,"_source":{"username":"lisi22","age":22}},{"_index":"user","_type":"_doc","_id":"4","_score":1.0,"_source":{"username":"zhaoliu","age":44}},{"_index":"user","_type":"_doc","_id":"5","_score":1.0,"_source":{"username":"tianqi","age":55}}]},"aggregations":{"lterms#age_group":{"doc_count_error_upper_bound":0,"sum_other_doc_count":0,"buckets":[{"key":22,"doc_count":2},{"key":11,"doc_count":1},{"key":44,"doc_count":1},{"key":55,"doc_count":1}]}}}
        System.out.println(response);

    }


}
