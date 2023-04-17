package com.lin.rabbitmq.consumer;

import com.lin.rabbitmq.constant.QueueConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: rabbitmq-springboot
 * @description: 警告队列中的消费者
 * @author: linsz
 * @create: 2022-07-19 05:48
 **/
@Component
@Slf4j
public class WarningConsumer {

    //    备份交换机优先级高
    @RabbitListener(queues = QueueConstant.WarningQueue)
    public void receiveWarningQueueMessage(Message message) {
        log.warn("这是警告中的消息：{}", message);
    }
}
