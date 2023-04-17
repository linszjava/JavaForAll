package com.lin.order.controller;

import com.lin.common.result.CommonResult;
import com.lin.order.lb.MyLoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Objects;

/**
 * @program: springcloud
 * @description: getForEntity测试
 * @author: linsz
 * @create: 2022-08-18 15:56
 **/
@RestController
@Slf4j
public class RibbonController {

    private static final String BASE_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MyLoadBalance myLoadBalance;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/getEntity/{id}")
    public CommonResult getEntity(@PathVariable Integer id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(BASE_URL + "/payment/get/" + id, CommonResult.class, id);
        HttpStatus statusCode = forEntity.getStatusCode();
        if (statusCode.is2xxSuccessful()){
            return forEntity.getBody();
        }else {
            return new CommonResult().fail();
        }
    }

    @GetMapping("/consumer/payment/lb")
    public CommonResult getLb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (Objects.isNull(instances) || instances.size()<=0)
            return new CommonResult().fail();
        ServiceInstance serviceInstance = myLoadBalance.instances(instances);

        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/discovery/getInfo", CommonResult.class);

    }



}
