package com.lin.es;

import com.lin.es.dao.ProductDao;
import com.lin.es.dto.ProductDTO;
import com.lin.es.entity.Product;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: es-springboot
 * @description: 测试类
 * @author: linsz
 * @create: 2022-07-27 04:23
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private ProductDao productDao;

    @Test
    public void createIndex(){
        System.out.println("创建索引成功");
    }

    @Test
    public void deleteIndex(){
//        @deprecated since 4.0, use {@link IndexOperations#delete()}
        elasticsearchRestTemplate.deleteIndex("product");

    }

    @Test
    public void testSave(){
        ProductDTO product = new ProductDTO();
        product.setId(2L);
        product.setTitle("华为手机");
        product.setCategory("手机");
        product.setPrice(2999.0);
        product.setImages("http://www.atguigu/hw.jpg");

        productDao.save(product);
        System.out.println("保存成功");
    }

    @Test
    public void testUpdate(){
        ProductDTO product = new ProductDTO();
        product.setId(2L);
        product.setTitle("小黑 22 手机");
        product.setCategory("手机");
        product.setPrice(19999.0);
        product.setImages("http://www.atguigu/xm.jpg");

        productDao.save(product);
    }

    @Test
    public void findById(){
        ProductDTO productDTO = productDao.findById(2l).get();
        System.out.println(productDTO);
    }

    @Test
    public void findAll(){
        Iterable<ProductDTO> products = productDao.findAll();
       products.forEach(System.out::println);
    }

    @Test
    public void delete(){
        ProductDTO product = new ProductDTO();
        product.setId(2L);
        productDao.delete(product);
    }

    @Test
    public void saveAll(){
        List<ProductDTO> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ProductDTO product = new ProductDTO(); product.setId(Long.valueOf(i)); product.setTitle("["+i+"]小米手机"); product.setCategory("手机"); product.setPrice(1999.0+i); product.setImages("http://www.atguigu/xm.jpg");
            productList.add(product);
        }
        productDao.saveAll(productList);
    }

    @Test
    public void testPage(){
        PageRequest pageRequest = PageRequest.of(0, 4, Sort.by(Sort.Direction.DESC,"id"));
        Page<ProductDTO> pages = productDao.findAll(pageRequest);
        pages.forEach(System.out::println);
    }

    /**
     * 查询价格大于两千的手机 分页查询
     */
    @Test
    public void testSearch(){
        PageRequest pageRequest = PageRequest.of(0, 5);
        Page<ProductDTO> search = productDao.search(QueryBuilders.rangeQuery("price").gte("2000"), pageRequest);
        for (ProductDTO productDTO : search) {
            System.out.println(productDTO);
        }
    }
}
