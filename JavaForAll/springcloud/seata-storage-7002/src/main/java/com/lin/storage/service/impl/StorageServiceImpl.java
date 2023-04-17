package com.lin.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.storage.entities.Storage;
import com.lin.storage.service.StorageService;
import com.lin.storage.mapper.StorageMapper;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author linsz
* @description 针对表【t_storage】的数据库操作Service实现
* @createDate 2022-09-02 16:37:21
*/
@Service
@Slf4j
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage>
    implements StorageService{

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void decreaseProduct(Long productId, Integer count) {
        log.info("storage: 开始调用减库存操作》》》》》》 ");
        log.info("=======================库存被调用===============================");
        Storage storage = storageMapper.selectById(productId);
        storage.setUsed(storage.getUsed() + count)
                .setResidue(storage.getResidue() - count);
        log.info("storage: 调用减库存操作完毕《《《《《《《 ");
    }
}




