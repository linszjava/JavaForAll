package com.lin.controller;

import com.lin.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @program: springcloud
 * @description: 服务发现控制层
 * @author: linsz
 * @create: 2022-08-17 15:40
 **/
@RestController
@Slf4j
public class DiscoveryController {

    //    import org.springframework.cloud.client.discovery.DiscoveryClient;
    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/discovery/getInfo")
    public CommonResult getDiscoveryInfo(){
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("services",services);
        resultMap.put("instances",instances);

        return new CommonResult().ok(resultMap);
    }



}
