package com.lin.storage.service;

import com.lin.storage.entities.Storage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author linsz
* @description 针对表【t_storage】的数据库操作Service
* @createDate 2022-09-02 16:37:21
*/
public interface StorageService extends IService<Storage> {

    void decreaseProduct(Long productId,Integer count);

}
