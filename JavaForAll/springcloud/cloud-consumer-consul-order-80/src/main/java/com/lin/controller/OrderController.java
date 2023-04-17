package com.lin.controller;

import com.lin.common.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud
 * @description: 测试consul 控制层
 * @author: linsz
 * @create: 2022-08-17 19:26
 **/
@RestController
public class OrderController {

    private static final String BASE_URL = "http://cloud-consul-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/consul/get")
    public CommonResult getInfo(){
        return restTemplate.getForObject(BASE_URL+"/payment/get",CommonResult.class);
    }
}
