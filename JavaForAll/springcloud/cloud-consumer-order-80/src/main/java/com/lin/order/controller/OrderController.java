package com.lin.order.controller;

import com.lin.common.entities.Payment;
import com.lin.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * @program: springcloud
 * @description: 订单调用支付控制层
 * @author: linsz
 * @create: 2022-08-12 15:47
 **/
@RestController
@Slf4j
public class OrderController {

//    private static final String BASE_URL = "http://localhost:8001";
    private static final String BASE_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;



    /**
     * 调用支付服务 获得接口
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getSerial(@PathVariable("id")Long id){
        CommonResult commonResult = restTemplate.getForObject(BASE_URL + "/payment/get/" + id, CommonResult.class, id);
        return commonResult;
    }

    /**
     * 调用支付服务 增加序列号
     * @param payment
     * @return
     */
    @GetMapping("/consumer/payment/add")
    public CommonResult addSerial(@RequestBody Payment payment){
        CommonResult commonResult = restTemplate.postForObject(BASE_URL + "/payment/add/", payment, CommonResult.class);
        return commonResult;
    }


}
