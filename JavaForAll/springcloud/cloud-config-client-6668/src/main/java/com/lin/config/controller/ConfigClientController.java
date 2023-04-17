package com.lin.config.controller;

import com.lin.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @program: springcloud
 * @description: configClient 控制层
 * @author: linsz
 * @create: 2022-08-23 23:17
 **/
@RestController
@Slf4j
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;


    @Value("${message}")
    private String message;

    @GetMapping("/getInfo")
    public CommonResult getInfo(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("serverPort",serverPort);
        hashMap.put("msg",message);

        return new CommonResult().ok(hashMap);
    }
}
