package com.lin.mapper;

import com.lin.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author linsz
* @description 针对表【t_product】的数据库操作Mapper
* @createDate 2022-07-29 06:59:03
* @Entity com.lin.pojo.Product
*/
@Repository
public interface ProductMapper extends BaseMapper<Product> {

}




