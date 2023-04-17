package com.lin.controller;

import com.lin.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

/**
 * @program: springcloud
 * @description: 测试consul 控制层
 * @author: linsz
 * @create: 2022-08-17 19:10
 **/
@RestController
@Slf4j
public class ConsulController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/get")
    public CommonResult getInfo(){
        String uuid = UUID.randomUUID().toString();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("port",port);
        hashMap.put("uuid",uuid);
        return new CommonResult().ok(hashMap);
    }
}
