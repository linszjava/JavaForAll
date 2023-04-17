package com.lin.order.controller;

import cn.hutool.core.lang.intern.InternUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lin.common.enums.CodeEnum;
import com.lin.common.result.CommonResult;
import com.lin.order.openfeign.OpenfeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @program: springcloud
 * @description: order 控制层
 * @author: linsz
 * @create: 2022-08-31 21:03
 **/
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OpenfeignService openfeignService;

    /**
     * 如果同时配置了fallback  和sentinel 的服务降级 则先进行fallback再降级熔断
     * @param id
     * @return
     */
    @GetMapping("/consumer/get/{id}")
//    @SentinelResource(value = "fallback", fallback = "fallbackMethod")
//    @SentinelResource(value = "fallback", blockHandler = "blockHandleMethod")
//    @SentinelResource(value = "fallback",fallback ="fallbackMethod"  ,blockHandler = "blockHandleMethod")
    @SentinelResource(value = "fallback",fallback ="fallbackMethod"  ,
            blockHandler = "blockHandleMethod",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult getIDFromPayment(@PathVariable("id") Integer id){
        CommonResult result = openfeignService.getDataById(id);
        if (id == 4 ){
            throw  new IllegalArgumentException("输入的参数非法异常");
        }else if (Objects.isNull(result.getData())){
            throw new NullPointerException("没有对应的记录数");
        }
        return result;
    }

    public CommonResult fallbackMethod(Integer id){
        return new CommonResult(450,"fallback默认回调的方法");
    }

    public CommonResult blockHandleMethod(Integer id, BlockException blockException){
        return new CommonResult(451,"blockHandleException统一处理办法");
    }

    @GetMapping("/consumer/openfeign/{id}")
    public CommonResult getOpenfeignId(@PathVariable("id")Integer id){
        /**
         * 默认让服务端休息三秒 不配置肯定会在客户端超时报错，我们测试是否客户端能进行自我降级
         */
        return openfeignService.getSleepId(id);

    }


}
