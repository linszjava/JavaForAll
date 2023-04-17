package com.lin.consumer.controller;

import com.lin.common.result.CommonResult;
import com.lin.consumer.listener.ReceiveMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud
 * @description: 接收消息控制层
 * @author: linsz
 * @create: 2022-08-24 15:54
 **/
@RestController
@Slf4j
public class ReceiveMessageController {

    @Autowired
    private ReceiveMessageListener receiveMessageListener;

    @GetMapping("/getMessage")
    public String getMessage(Message<String> message){
        String messagePayload = message.getPayload();
        log.info("message:===========>{}",messagePayload);
        return messagePayload;
    }


}
