package com.lin.hystrix.service.fallback;

import com.lin.common.enums.CodeEnum;
import com.lin.common.result.CommonResult;
import com.lin.hystrix.service.PaymentHystrixOpenfeignService;
import org.springframework.stereotype.Component;

/**
 * @program: springcloud
 * @description: 对应service执行 统一回调处理
 * @author: linsz
 * @create: 2022-08-22 14:11
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixOpenfeignService {
    @Override
    public CommonResult getOk(Integer id) {
        return new CommonResult(CodeEnum.UNKNOWN.getCode(), CodeEnum.UNKNOWN.getMessage());
    }

    @Override
    public CommonResult getFail(Integer id) {
        return new CommonResult(CodeEnum.UNKNOWN.getCode(), CodeEnum.UNKNOWN.getMessage());
    }
}
