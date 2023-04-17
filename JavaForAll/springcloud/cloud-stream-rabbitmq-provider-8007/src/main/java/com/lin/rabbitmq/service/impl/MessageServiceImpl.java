package com.lin.rabbitmq.service.impl;

import cn.hutool.core.util.IdUtil;
import com.lin.common.result.CommonResult;
import com.lin.rabbitmq.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.HashMap;

/**
 * @program: springcloud
 * @description: 消息发送接口的实现类
 * @author: linsz
 * @create: 2022-08-24 14:21
 **/
@EnableBinding(Source.class)
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageChannel output;
    @Override
    public CommonResult sendMessage() {
        HashMap<String, Object> hashMap = new HashMap<>();
        String uuid = IdUtil.fastSimpleUUID();
        log.info("uuid is =================>{}",uuid);
        boolean isSend = output.send(MessageBuilder.withPayload(uuid).build());
        hashMap.put("uuid",uuid);
        hashMap.put("is_send",isSend);
        return new CommonResult().ok(hashMap);
    }
}
