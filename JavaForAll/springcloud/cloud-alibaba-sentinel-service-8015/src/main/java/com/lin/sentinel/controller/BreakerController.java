package com.lin.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lin.common.enums.CodeEnum;
import com.lin.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @program: springcloud
 * @description: 熔断 热点key 控制层
 * @author: linsz
 * @create: 2022-08-30 21:08
 **/
@RestController
@Slf4j
public class BreakerController {

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_HotKeyHandler")
    public CommonResult getTestHotKey(
            @RequestParam(value = "p1",required = false) String p1,
            @RequestParam(value = "p2",required = false) String p2
    ){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("p1",p1);
        resultMap.put("p2",p2);
        resultMap.put("msg","testHotKeyOK");
        return new CommonResult().ok(resultMap);
    }

    public CommonResult deal_HotKeyHandler(String p1, String p2, BlockException exception){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("exception",exception);
        resultMap.put("deal_handler","I am the handler of blockException");
        return new CommonResult().ok(resultMap);
    }


}
