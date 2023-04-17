package com.lin.es.client;

import com.alibaba.fastjson.JSON;
import com.lin.es.pojo.User;
import com.lin.es.utils.ClientUtils;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.get.GetResult;

import java.io.IOException;

/**
 * @program: es-client
 * @description: 文档测试
 * @author: linsz
 * @create: 2022-07-24 06:42
 **/
public class DocumentDemo {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ClientUtils.getClient();
//        1、新增
//        IndexRequest request = new IndexRequest("user");
//        User user = new User();
//        user.setId(1).setUsername("林谦").setAge(23);
//
//        request.id(String.valueOf(user.getId()));
//        request.source(JSON.toJSONString(user), XContentType.JSON);
//        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
//        System.out.println(result);

//        2、修改
//        UpdateRequest user = new UpdateRequest("user", "1");
////        局部修改的参数
//        user.doc(XContentType.JSON,"username","林谦22");
//        UpdateResponse response = client.update(user, RequestOptions.DEFAULT);
//
//        System.out.println(response.getIndex());
//        System.out.println(response.getId());
//        System.out.println(response.getResult());
//        3.查看
//        GetResponse response = client.get(new GetRequest("user", "1"), RequestOptions.DEFAULT);
//        System.out.println(response.getSourceAsString());
//        4.删除
        DeleteResponse response = client.delete(new DeleteRequest("user", "1"), RequestOptions.DEFAULT);
        System.out.println(response.status().toString());


        ClientUtils.closeClient();
    }
}
