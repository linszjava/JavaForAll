package com.lin.order.openfeign.fallback;

import com.lin.common.enums.CodeEnum;
import com.lin.common.result.CommonResult;
import com.lin.order.openfeign.OpenfeignService;
import org.springframework.stereotype.Component;

/**
 * @program: springcloud
 * @description: openfeignService 实现类  对熔断进行fallback 处理
 * @author: linsz
 * @create: 2022-08-31 20:54
 **/
@Component
public class OpenfeignServiceFallBack implements OpenfeignService {
    /**
     * 调用 Payment 控制层的接口 失败的统一返回结果响应
     *
     * @param id
     * @return
     */
    @Override
    public CommonResult getId(Integer id) {
        return new CommonResult(CodeEnum.SENTINEL_EXCEPTION.getCode(), CodeEnum.SENTINEL_EXCEPTION.getMessage());
    }

    @Override
    public CommonResult getDataById(Integer id) {
        return new CommonResult(CodeEnum.SENTINEL_EXCEPTION.getCode(), CodeEnum.SENTINEL_EXCEPTION.getMessage());
    }

    @Override
    public CommonResult getSleepId(Integer id) {
        return new CommonResult(CodeEnum.SENTINEL_EXCEPTION.getCode(), CodeEnum.SENTINEL_EXCEPTION.getMessage());
    }
}
