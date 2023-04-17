package com.lin.hystrix.controller;

import com.lin.common.enums.CodeEnum;
import com.lin.common.result.CommonResult;
import com.lin.hystrix.service.PaymentHystrixOpenfeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud
 * @description: hystrix 控制层测试
 * @author: linsz
 * @create: 2022-08-21 17:10
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallbackExceptionHandle")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixOpenfeignService paymentHystrixOpenfeignService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public CommonResult getOk(@PathVariable Integer id){
        return paymentHystrixOpenfeignService.getOk(id);
    }

    /**
     * 消费端自定义 超时回调方法  服务降级
     * 未解决问题：只使用@HystrixCommand 不使用其他的默认回调之类的声明，
     * 不论是否在请求超过几秒，比如说如果是1-2s,是不算错误的，消费端会正常返回
     * 但是我这个的问题是，只要加了这个注解，那就是不论几秒都是会返回回调函数，这明显不符合实际预期！
     * 这个问题有待考究！！
     * @param id
     * @return
     */
    @GetMapping("/consumer/hystrix/fail/{id}")
//    @HystrixCommand(fallbackMethod = "timeoutFallbackMethod",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3000")
//    })
    @HystrixCommand
    public CommonResult getFail(@PathVariable("id") Integer id){
        return paymentHystrixOpenfeignService.getFail(id);
    }

    public CommonResult timeoutFallbackMethod(@PathVariable("id") Integer id){
        return new CommonResult(449,"我是消费端80超时失败的返回方法");
    }

    public CommonResult globalFallbackExceptionHandle(){
        return new CommonResult(CodeEnum.UNKNOWN.getCode(), CodeEnum.UNKNOWN.getMessage());
    }


}
