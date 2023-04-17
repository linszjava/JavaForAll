package com.lin.hystrix.controller;

import com.lin.common.enums.CodeEnum;
import com.lin.common.result.CommonResult;
import com.lin.hystrix.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @program: springcloud
 * @description: payment  hystrix 控制层测试类
 * @author: linsz
 * @create: 2022-08-21 16:08
 **/
@RestController
@Slf4j
public class PaymentHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    /**
     * 该id 无实意
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public CommonResult getOk(@PathVariable("id") Integer id){
        CommonResult commonResult = paymentHystrixService.paymentInfo_OK(id);
        return commonResult;
    }

    /**
     * 设置3秒超时执行默认回调
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/fail/{id}")
    public CommonResult getFail(@PathVariable("id") Integer id){
        CommonResult commonResult = paymentHystrixService.paymentInfo_Fail(id);
        return commonResult;
    }

    /**
     * 服务熔断
     * @param id
     * @return
     */
    @GetMapping("/payment/getRightId/{id}")
    public CommonResult getRightId(@PathVariable Integer id){
        return paymentHystrixService.getRightId(id);
    }



}
