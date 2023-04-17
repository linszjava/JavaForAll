package com.lin.hystrix.fallback;

import com.lin.common.enums.CodeEnum;
import com.lin.common.result.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @program: springcloud
 * @description: 全局异常返回
 * @author: linsz
 * @create: 2022-08-22 16:13
 **/
public class GlobalFallback {

    public CommonResult globalFallbackMethod(){
        return new CommonResult(499,"我是服务端全局异常返回统一定义");
    }
}
