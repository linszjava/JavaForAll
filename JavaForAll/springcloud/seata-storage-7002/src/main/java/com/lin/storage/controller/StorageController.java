package com.lin.storage.controller;

import com.lin.common.result.CommonResult;
import com.lin.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud
 * @description: 库存控制层
 * @author: linsz
 * @create: 2022-09-05 15:01
 **/
@RestController
@Slf4j
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult decreaseStorage(@RequestParam("productId")Long productId,
                                         @RequestParam("count") Integer count){
        storageService.decreaseProduct(productId, count);
        return new CommonResult(666,"storage微服务库存扣减成功");

    }
}
