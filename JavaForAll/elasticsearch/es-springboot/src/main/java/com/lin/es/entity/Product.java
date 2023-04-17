package com.lin.es.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @program: es-springboot
 * @description: 商品实体类
 * @author: linsz
 * @create: 2022-07-27 04:02
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Product {
    /**
     * 商品id
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 分类
     */
    private String category;
    /**
     * 价格
     */
    private Double price;
    /**
     * 图片地址
     */
    private String images;
}
