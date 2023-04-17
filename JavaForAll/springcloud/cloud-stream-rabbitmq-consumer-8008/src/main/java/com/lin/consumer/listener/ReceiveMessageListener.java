package com.lin.consumer.listener;

import com.lin.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @program: springcloud
 * @description: 接收消息监听器
 * @author: linsz
 * @create: 2022-08-24 16:03
 **/
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListener {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void getMsg(Message<String> message){
        String payload = message.getPayload();
        log.info("message:===========>{},serverPort:{}",payload,serverPort);
    }
}
