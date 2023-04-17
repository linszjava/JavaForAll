package com.lin.type.topic;

import com.lin.constant.ExchangeConstant;
import com.lin.constant.QueueConstant;
import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

/**
 * @program: rabbitmq
 * @description: topic 消费者
 * @author: linsz
 * @create: 2022-07-17 00:25
 **/
public class Consumer2 {


    public static void main(String[] args) throws Exception {
        Channel channel = AmqpUtils.getChannel();
        channel.exchangeDeclare(ExchangeConstant.TopicExchange, BuiltinExchangeType.TOPIC);
        channel.queueDeclare(QueueConstant.TopicQueueName_2, false, false, false, null);
        channel.queueBind(QueueConstant.TopicQueueName_2, ExchangeConstant.TopicExchange, "info.*");
        System.out.println("消费者2在等待消费----》");
        channel.basicConsume(QueueConstant.TopicQueueName_2, (consumerTag, message) -> {
            System.out.println(QueueConstant.TopicQueueName_2 + ":" + message.getEnvelope().getRoutingKey() + ":" +
                    new String(message.getBody()));

        }, consumerTag -> {
            System.out.println("这是失败时消费者2的回调函数");
        });
    }
}
