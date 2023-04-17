package com.lin.nacos.controller;

import com.lin.common.enums.CodeEnum;
import com.lin.common.result.CommonResult;
import com.lin.nacos.service.OpenfeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud
 * @description: order 测试控制层
 * @author: linsz
 * @create: 2022-08-25 17:30
 **/
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OpenfeignService openfeignService;

    @GetMapping("/consumer/get/{id}")
    public CommonResult getInfoFromPayment(@PathVariable Integer id){
        return openfeignService.getId(id);
    }
}
