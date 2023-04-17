package com.lin.sentinel.controller;

import com.lin.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description: sentinel 控制层
 * @author: linsz
 * @create: 2022-08-28 01:07
 **/
@RestController
@Slf4j
public class SentinelController {

    /**
     *
     *  快速失败： 当超过预期的QPS，每秒所能接收的请求数时，将直接失败
     *  Blocked by Sentinel (flow limiting)
     * @return
     */
    @GetMapping("/testA")
    public CommonResult testA(){
        return new CommonResult().ok("testA");
    }

    @GetMapping("/testB")
    public CommonResult testB(){
        return new CommonResult().ok("testB");
    }

    /**
     * 测试RT
     * @return
     */
    @GetMapping("/testC")
    public CommonResult testC(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult().ok("testC");
    }

    /**
     * 测试异常比例
     * @return
     */
    @GetMapping("/testD")
    public CommonResult testD(){
        int i = 10 / 0 ;
        return new CommonResult().ok("testD");
    }

    /**
     * 测试异常数
     * @return
     */
    @GetMapping("/testE")
    public CommonResult testE(){
        int i = 10 / 0 ;
        return new CommonResult().ok("testE");
    }


}
