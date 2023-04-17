package com.lin.nacos.controller;

import com.lin.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

/**
 * @program: springcloud
 * @description: payment 控制层
 * @author: linsz
 * @create: 2022-08-25 16:56
 **/
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public CommonResult getId(@PathVariable("id")Integer id){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("serverPort",serverPort);
        hashMap.put("id",id);
        return new CommonResult().ok(hashMap);

    }
}
