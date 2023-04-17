package com.lin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.pojo.Product;
import com.lin.service.ProductService;
import com.lin.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author linsz
* @description 针对表【t_product】的数据库操作Service实现
* @createDate 2022-07-29 06:59:03
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




