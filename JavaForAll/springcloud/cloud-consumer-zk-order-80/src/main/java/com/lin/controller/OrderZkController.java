package com.lin.controller;

import com.lin.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud
 * @description: 调用payment的order控制层
 * @author: linsz
 * @create: 2022-08-17 18:23
 **/
@RestController
@Slf4j
public class OrderZkController {

    private static final String BASE_URL = "http://cloud-zk-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/zk/get")
    public CommonResult getSerial(){
        CommonResult commonResult = restTemplate.getForObject(BASE_URL + "/zk/payment/get", CommonResult.class);
        return commonResult;
    }
}
