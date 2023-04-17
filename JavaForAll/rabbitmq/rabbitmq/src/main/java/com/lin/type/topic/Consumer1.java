package com.lin.type.topic;

import com.lin.constant.ExchangeConstant;
import com.lin.constant.QueueConstant;
import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @program: rabbitmq
 * @description: topic 消费者
 * @author: linsz
 * @create: 2022-07-17 00:25
 **/
public class Consumer1 {


    public static void main(String[] args) throws Exception {
        Channel channel = AmqpUtils.getChannel();
        channel.exchangeDeclare(ExchangeConstant.TopicExchange, BuiltinExchangeType.TOPIC);
        channel.queueDeclare(QueueConstant.TopicQueueName, false, false, false, null);
        channel.queueBind(QueueConstant.TopicQueueName, ExchangeConstant.TopicExchange, "info.#");
        channel.queueBind(QueueConstant.TopicQueueName, ExchangeConstant.TopicExchange, "*.warning.*");

        System.out.println("消费者1在等待消费----》");
        channel.basicConsume(QueueConstant.TopicQueueName, (consumerTag, message) -> {
            System.out.println(QueueConstant.TopicQueueName + ":" + message.getEnvelope().getRoutingKey() + ":" +
                    new String(message.getBody()));

        }, consumerTag -> {
            System.out.println("这是失败时消费者1的回调函数");
        });
    }
}
