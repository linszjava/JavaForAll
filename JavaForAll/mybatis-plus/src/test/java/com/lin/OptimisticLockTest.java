package com.lin;

import com.lin.pojo.Product;
import com.lin.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: mybatisplus-springboot
 * @description: 乐观锁测试
 * @author: linsz
 * @create: 2022-07-29 09:46
 **/
@SpringBootTest
public class OptimisticLockTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testProductWithoutVersion(){
        //小林从数据库读数据
        Product productLin = productMapper.selectById(1);

        //罪孽深重的原因在于读取了同一份数据，并在很久之后才修改，再这之间有人重新提交了数据，但自己还是拿到原来旧的数据去修改
        Product productWang = productMapper.selectById(1);

        //小林修改了数据
        productLin.setPrice(productLin.getPrice()+50);
        productMapper.updateById(productLin);

        //小王修改了数据
        productWang.setPrice(productWang.getPrice()-30);
        int result = productMapper.updateById(productWang);
        if (result ==0){
            //其实就是拉取最新的
            productMapper.selectById(1);
            productWang.setPrice(productWang.getPrice()-30);
        }

        //boss
        System.out.println(productMapper.selectById(1));
    }
}
