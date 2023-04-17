package com.lin.rabbitmq.controller;

import com.lin.common.result.CommonResult;
import com.lin.rabbitmq.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud
 * @description: 发送端控制层
 * @author: linsz
 * @create: 2022-08-24 14:27
 **/
@RestController
@Slf4j
public class SendController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/sendMessage")
    public CommonResult sendMessage(){
        return messageService.sendMessage();
    }
}
