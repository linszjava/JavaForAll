package com.lin.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lin.common.entities.Payment;
import com.lin.common.result.CommonResult;
import com.lin.sentinel.handle.GlobalHandleException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @program: springcloud
 * @description: @SentinelResource 测试使用
 * @author: linsz
 * @create: 2022-08-31 16:40
 **/
@RestController
@Slf4j
public class RateLimitController {

    /**
     * 如果按资源名称进行限流 那么如果都限流处理方法 那么执行限流处理方法
     * 如 handleException
     * @return
     */
    @GetMapping("/testByResourceName")
    @SentinelResource(value = "testByResourceName",blockHandler = "handleException")
    public CommonResult testByResourceName(){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg","按资源名称限流");
        resultMap.put("payment",new Payment(66l,"20220831"));
        return new CommonResult().ok(resultMap);
    }

    public CommonResult handleException(BlockException blockException){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("exception",blockException);
        resultMap.put("ExceptionClassName",blockException.getClass().getCanonicalName());
        return new CommonResult(555,"错误统一处理返回信息",resultMap);
    }

    @GetMapping("/testByUrl")
    @SentinelResource(value = "/byUrl",blockHandler = "handleExceptionWithUrl")
    public CommonResult testByUrl(){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg","按路径限流");
        resultMap.put("payment",new Payment(88l,"202208311850"));
        return new CommonResult().ok(resultMap);
    }

    public CommonResult handleExceptionWithUrl(BlockException exception){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("exception",exception);
        resultMap.put("ExceptionClassName",exception.getClass().getCanonicalName());
        return new CommonResult(555,"根据url地址限流错误的统一处理办法",resultMap);
    }

    /**
     * 通过对上文的 对资源名称和对url路径进行测试发现如下
     *
     * 1. 对于资源名称进行限流设置  如果被限流则调用对应的兜底方法或者叫统一限流返回方法
     * 2. 但是 对弈通过url 进行限流 不论是否有兜底的方法，均采用sentinel默认限流的返回方法
     */


    /**
     * 测试使用全局异常统一返回
     * @return
     */
    @GetMapping("/testByGlobal")
    @SentinelResource(value = "testByGlobal",
            blockHandlerClass = GlobalHandleException.class, blockHandler = "globalComplexExceptionHandler")
    public CommonResult testByGlobal(){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg","按资源名称限流且测试全局异常统一返回");
        resultMap.put("payment",new Payment(66l,"20220831"));
        return new CommonResult().ok(resultMap);
    }

}
