package com.lin.nacos.service;

import com.lin.common.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: springcloud
 * @description: openfeign接口层
 * @author: linsz
 * @create: 2022-08-25 17:28
 **/
@Component
@FeignClient("cloud-nacos-payment-service")
public interface OpenfeignService {

    @GetMapping("/payment/get/{id}")
     CommonResult getId(@PathVariable("id")Integer id);


}
