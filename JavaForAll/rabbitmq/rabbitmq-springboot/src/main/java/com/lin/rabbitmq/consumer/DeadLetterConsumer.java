package com.lin.rabbitmq.consumer;

import com.lin.rabbitmq.constant.QueueConstant;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @program: rabbitmq-springboot
 * @description: 死信队列消费者
 * @author: linsz
 * @create: 2022-07-18 04:28
 **/
@Component
@Slf4j
public class DeadLetterConsumer {


    @RabbitListener(queues = QueueConstant.DeadQueue)
    public void receiveMessageWithTime(Message message) throws IOException {
        String msg = new String(message.getBody());

        log.info("接收到死信队列中的时间为：{},消息为：{}",
                LocalDateTime.now(), msg);

    }
}
