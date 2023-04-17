package com.lin.es.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


/**
 * @program: es-springboot
 * @description: 商品类映射操作
 * @author: linsz
 * @create: 2022-07-27 04:09
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "product",shards = 3)
public class ProductDTO {

    /**
     * 商品id
     */
    @Id
    private Long id;
    /**
     * 标题
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;
    /**
     * 分类
     */
    @Field(type = FieldType.Keyword)
    private String category;
    /**
     * 价格
     */
    @Field(type = FieldType.Double)
    private Double price;
    /**
     * 图片地址
     */
    @Field(type = FieldType.Keyword,index = false)
    private String images;
}
