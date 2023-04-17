package com.lin.controller;

import com.lin.common.entities.Payment;
import com.lin.common.result.CommonResult;
import com.lin.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description: 支付控制层
 * @author: linsz
 * @create: 2022-08-11 20:34
 **/
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;


    @GetMapping("/payment/get/{id}")
    public CommonResult getSerial(@PathVariable("id") Long id){

        HashMap<String, Object> resultMap = new HashMap<>();
        Payment payment = paymentService.getById(id);
        resultMap.put("payment",payment);
        resultMap.put("port",port);
        log.info("根据id查询支付流水号：payment:{}",payment);
        if (payment!=null){
            return new CommonResult<>().ok(resultMap);
        }else
            return new CommonResult<>().fail();

    }

    @PostMapping("/payment/add")
    public CommonResult<Payment> addPayment(@RequestBody Payment payment){
        boolean isPayment = paymentService.save(payment);
        if (isPayment)
            return new CommonResult<>().ok(payment);
        else{
            return new CommonResult<>().fail();
        }
    }

    @GetMapping("/payment/getForFeign/{id}")
    public CommonResult getSerialForFeign(@PathVariable("id")Long id){
        Payment payment = paymentService.getById(id);
        return new CommonResult().ok(payment);
    }

    @GetMapping("/payment/testTimeOut")
    public CommonResult returnTime(){
        int timeForOut = 3;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("port",port);
        hashMap.put("timeForOut",timeForOut);
        try {
            TimeUnit.SECONDS.sleep(timeForOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("暂停时间为：{}",timeForOut);
        return new CommonResult().ok(hashMap);
    }
}
