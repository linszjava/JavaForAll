package com.lin.config.controller;

import com.lin.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud
 * @description: 客户端config 控制层
 * @author: linsz
 * @create: 2022-08-23 22:17
 **/
@RestController
@Slf4j
@RefreshScope
public class ConfigController {

//    @Value("${config.info}")
    @Value("${message}")
    private String info;

    @GetMapping("/getInfo")
    public CommonResult getInfoFromTheConfigServer(){
        log.info("the info from the config server is :{}",info);
        return new CommonResult().ok(info);
    }
}
