package com.lin.hystrix.service.impl;

import cn.hutool.core.util.IdUtil;
import com.lin.common.enums.CodeEnum;
import com.lin.common.result.CommonResult;
import com.lin.hystrix.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description: paymentHystrixService 实现类
 * @author: linsz
 * @create: 2022-08-21 15:58
 **/
@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    /**
     * 模拟测试成功测试返回
     *
     * @param id
     * @return
     */
    @Override
    public CommonResult paymentInfo_OK(Integer id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String threadName = Thread.currentThread().getName();
        hashMap.put("threadName",threadName);
        hashMap.put("输入的ID",id);
        return new CommonResult().ok(hashMap);
    }

    /**
     * 模拟测试超时 失败返回
     *
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "timeoutFallbackMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3000")
    })
    public CommonResult paymentInfo_Fail(Integer id) {

        HashMap<String, Object> hashMap = new HashMap<>();
        String threadName = Thread.currentThread().getName();
        hashMap.put("threadName",threadName);
        hashMap.put("睡眠的时间间隔为(s)",id);
        try {
            TimeUnit.SECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult().ok(hashMap);
    }

    public CommonResult timeoutFallbackMethod(@PathVariable("id") Integer id){
        return new CommonResult(CodeEnum.FAIL_TIMEOUT.getCode(),CodeEnum.FAIL_TIMEOUT.getMessage());
    }

    /**
     * 模拟得到正数成功 负数失败 测试熔断
     *
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "getRightIdFallbackMethod",
            commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "20") //错误率
    })
    public CommonResult getRightId(Integer id) {
        if (id <= 0){
            //注意：该处只能抛出异常，如果是以返回一个失败的json,data为空，则依旧不能实现熔断，就不能把你输入的当做错误了
            throw new RuntimeException("id 不能为负数");
//            return new CommonResult().fail(); // 不能返回CommonResult()
        }else{
            HashMap<String, Object> hashMap = new HashMap<>();
            String uuid = IdUtil.randomUUID();
            hashMap.put("threadName",Thread.currentThread().getName());
            hashMap.put("uuid",uuid);
            hashMap.put("id",id);
            return new CommonResult().ok(hashMap);

        }

    }

    public CommonResult getRightIdFallbackMethod(Integer id){
        return new CommonResult(499,"我是输入负数返回的异常统一处理 ");
    }
}
