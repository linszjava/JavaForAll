package com.lin.es.dao;

import com.lin.es.dto.ProductDTO;
import com.lin.es.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: es-springboot
 * @description: 商品dao
 * @author: linsz
 * @create: 2022-07-27 04:06
 **/
@Repository
public interface ProductDao extends ElasticsearchRepository<ProductDTO,Long> {


}
