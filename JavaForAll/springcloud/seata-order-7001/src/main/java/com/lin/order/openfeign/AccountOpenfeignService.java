package com.lin.order.openfeign;

import com.lin.common.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @program: springcloud
 * @description: openfeign调用Account 微服务
 * @author: linsz
 * @create: 2022-09-02 17:11
 **/
@FeignClient("seata-account-samples")
public interface AccountOpenfeignService {

    @PostMapping("/account/decreaseMoney")
    CommonResult getDecreaseMoney(@RequestParam("userId") Long userId,
                                  @RequestParam("money") BigDecimal money);
}
