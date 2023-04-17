package com.lin.order.openfeign;

import com.lin.common.result.CommonResult;
import com.lin.order.openfeign.fallback.OpenfeignServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: springcloud
 * @description: openfeignService 调用 Payment 接口
 * @author: linsz
 * @create: 2022-08-31 20:51
 **/
@FeignClient(value = "alibaba-sentinel-payment-service",fallback = OpenfeignServiceFallBack.class)
public interface OpenfeignService {

    /**
     * 调用 Payment 控制层的接口
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    CommonResult getId(@PathVariable("id")Integer id);

    @GetMapping("/payment/getData/{id}")
     CommonResult getDataById(@PathVariable("id")Integer id);

    @GetMapping("/payment/getSleep/{id}")
     CommonResult getSleepId(@PathVariable("id") Integer id);
}
