package com.lin.service;

import com.lin.common.entities.Payment;
import com.lin.common.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: springcloud
 * @description: openfeign调用payment接口 service层
 * @author: linsz
 * @create: 2022-08-18 21:54
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     * 注意: 如果我们拿到的是一个泛型是Payment的CommonResult<Payment> 那通过openfeign可以得到数据
     * 但是 像下文我们的payment那个微服务，我们封装的Object是一个map,微服务自己调没问题，但是如果是openfeign则会出现得不到数据的情况
     * 解决办法 ：  返回类型不论是微服务payment还是 openfeign 都不要写具体的泛型类型即可，只写CommonResult
     *
     * @param id
     * @return
     */
     @GetMapping("/payment/get/{id}")
     CommonResult getSerial(@PathVariable("id") Long id);

     @GetMapping("/payment/getForFeign/{id}")
      CommonResult getSerialForFeign(@PathVariable("id")Long id);

    @GetMapping("/payment/testTimeOut")
    public CommonResult returnTime();

    @GetMapping("/payment/zipkin")
     CommonResult getInfo();
}
