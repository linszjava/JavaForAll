package com.lin.type.direct;

import com.lin.constant.ExchangeConstant;
import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @program: rabbitmq
 * @description: 直连交换机 消费者  从本节开始 使用静态常量类声明交换机类型等
 * 该消费者 定义 接收direct-exchange 信道为 Q1 且路由key为info warning 的信息
 * @author: linsz
 * @create: 2022-07-16 17:21
 **/
public class Consumer {

    private static final String QueueName = "Q1";

    public static void main(String[] args) throws Exception {
        Channel channel = AmqpUtils.getChannel();
        channel.exchangeDeclare(ExchangeConstant.DirectExchange, BuiltinExchangeType.DIRECT);
        channel.queueDeclare(QueueName, false, false, false, null);
        channel.queueBind(QueueName, ExchangeConstant.DirectExchange, "info");
        channel.queueBind(QueueName, ExchangeConstant.DirectExchange, "warning");

        System.out.println("这是消费者1号，接收info和warning的信息");
        channel.basicConsume(QueueName, (consumerTag, message) -> {
            System.out.println("queue、routerKey为：" + QueueName + " " + message.getEnvelope().getRoutingKey() + "内容为：" + new String(message.getBody()));
        }, consumerTag -> {
            System.out.println("这是消费者失败的回调函数");
        });
    }
}
