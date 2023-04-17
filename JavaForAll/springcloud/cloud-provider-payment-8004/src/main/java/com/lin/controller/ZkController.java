package com.lin.controller;

import com.lin.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

/**
 * @program: springcloud
 * @description: 测试payment控制层  服务发现为zookeeper
 * @author: linsz
 * @create: 2022-08-17 17:33
 **/
@RestController
@Slf4j
public class ZkController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/zk/payment/get")
    public CommonResult getInfo(){
        String uuid = UUID.randomUUID().toString();
        HashMap<String, Object> map = new HashMap<>();
        map.put("uuid",uuid);
        map.put("port",port);
        return new CommonResult().ok(map);
    }
}
