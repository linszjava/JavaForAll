package com.lin.nacos.controller;

import com.lin.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springcloud
 * @description: 配置控制层 ： 测试是否能从nacos 正常获取配置
 * @author: linsz
 * @create: 2022-08-25 21:20
 **/
@RestController
@Slf4j
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/payment/getConfigInfo")
    public CommonResult getConfigInfo(){
        return new CommonResult().ok(configInfo);
    }
}
