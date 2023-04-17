package com.lin.sentinel.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lin.common.result.CommonResult;

/**
 * @program: springcloud
 * @description: 全局异常处理类
 * @author: linsz
 * @create: 2022-08-31 17:21
 **/
public class GlobalHandleException {

    /**
     * 注意：  static  BlockException blockException 缺一不可
     * @param blockException
     * @return
     */
    public static CommonResult globalSimpleExceptionHandler(BlockException blockException){
        return new CommonResult(8888,"this is the global simple exception handler");
    }

    public static CommonResult globalComplexExceptionHandler(BlockException blockException){
        return new CommonResult(8888,"this is the global complex exception handler");
    }
}
