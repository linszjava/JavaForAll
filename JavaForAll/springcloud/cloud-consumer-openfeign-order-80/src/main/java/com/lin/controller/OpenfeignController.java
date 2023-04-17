package com.lin.controller;

import com.lin.common.entities.Payment;
import com.lin.common.result.CommonResult;
import com.lin.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @program: springcloud
 * @description: openfeign测试控制层
 * @author: linsz
 * @create: 2022-08-18 21:57
 **/
@RestController
@Slf4j
public class OpenfeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/openfeign/get/{id}")
    public CommonResult getSerialWithOpenfeign(@PathVariable("id") Long id){
        log.info("id为 ---》{}",id);
        CommonResult<Payment> paymentCommonResult = paymentFeignService.getSerial(id);
        log.info("payment结果为===》{}",paymentCommonResult);
       return paymentCommonResult;

    }

    @GetMapping("/consumer/getFromFeign/{id}")
    public CommonResult getFromFeign(@PathVariable("id")Long id){
        CommonResult commonResult = paymentFeignService.getSerialForFeign(id);
        return commonResult;
    }

    @GetMapping("/consumer/openfeign/testTimeOut")
    public CommonResult testOpenfeignTimeOut(){
        return paymentFeignService.returnTime();
    }


    @GetMapping("/consumer/zipkin")
    public CommonResult getInfoOfZipkin(){
        return paymentFeignService.getInfo();
    }
}
