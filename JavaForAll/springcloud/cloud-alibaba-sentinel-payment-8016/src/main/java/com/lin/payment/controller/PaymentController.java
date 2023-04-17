package com.lin.payment.controller;

import cn.hutool.core.util.IdUtil;
import com.lin.common.entities.Payment;
import com.lin.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description: payment 控制层
 * @author: linsz
 * @create: 2022-08-31 18:03
 **/
@RestController
@Slf4j
public class PaymentController {

    public static HashMap<Integer,Payment> dataHash = new HashMap<>(3);
    static {
        dataHash.put(1,new Payment(1l, "a360e0a541874640a6ae4df83e2aed41"));
        dataHash.put(2,new Payment(2l, "58154393cb2b432cba8a746851075b77"));
        dataHash.put(3,new Payment(3l, "71dd48de5d2242b6a56abdbc5acaa62a"));
    }

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public CommonResult getId(@PathVariable("id")Integer id){

        Payment payment = dataHash.get(id);

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("serverPort",serverPort);
        resultMap.put("id",id);
        resultMap.put("payment",payment);

        return new CommonResult().ok(resultMap);
    }

    @GetMapping("/payment/getData/{id}")
    public CommonResult getDataById(@PathVariable("id")Integer id){

//        return new CommonResult().ok(dataHash.get(id));
        return new CommonResult(666,"成功，且接口为"+serverPort,dataHash.get(id));
    }

    @GetMapping("/payment/getSleep/{id}")
    public CommonResult getSleepId(@PathVariable("id") Integer id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(666,"成功，且接口为"+serverPort,dataHash.get(id));

    }
}
