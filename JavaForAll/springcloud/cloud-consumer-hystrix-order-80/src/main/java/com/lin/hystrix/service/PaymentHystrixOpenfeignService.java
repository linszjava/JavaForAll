package com.lin.hystrix.service;

import com.lin.common.result.CommonResult;
import com.lin.hystrix.service.fallback.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: springcloud
 * @description: openfeign 调用payment 接口层
 * @author: linsz
 * @create: 2022-08-21 17:07
 **/

@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT-HYSTRIX-SERVICE-8006",fallback = PaymentFallbackService.class)
public interface PaymentHystrixOpenfeignService {

    @GetMapping("/payment/hystrix/ok/{id}")
     CommonResult getOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/fail/{id}")
     CommonResult getFail(@PathVariable("id") Integer id);


}
