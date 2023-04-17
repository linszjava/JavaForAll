package com.lin.rabbitmq.consumer;

import com.lin.rabbitmq.constant.QueueConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @program: rabbitmq-springboot
 * @description: 基于插件的延迟队列消费端
 * @author: linsz
 * @create: 2022-07-19 00:30
 **/

@Component
@Slf4j
public class DelayConsumer {

    @RabbitListener(queues = QueueConstant.DelayQueue)
    public void delayConsumer(Message message) {
        log.info("在时间为:{},消费端接收到一条消息为:{}", LocalDateTime.now(), new String(message.getBody()));
    }
}
