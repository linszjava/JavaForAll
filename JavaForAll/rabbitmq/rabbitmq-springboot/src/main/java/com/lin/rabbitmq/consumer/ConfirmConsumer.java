package com.lin.rabbitmq.consumer;

import com.lin.rabbitmq.constant.QueueConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: rabbitmq-springboot
 * @description: 发布确认的消费者
 * @author: linsz
 * @create: 2022-07-19 04:07
 **/
@Component
@Slf4j
public class ConfirmConsumer {

    @RabbitListener(queues = QueueConstant.ConfirmQueue)
    public void receiveConfirmConsumer(Message message) {
        log.info("消费者接受的消息为:{}", message);
    }
}
