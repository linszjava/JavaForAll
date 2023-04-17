package com.lin.type.direct;

import com.lin.constant.ExchangeConstant;
import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

/**
 * @program: rabbitmq
 * @description: 直连交换机 消费者  从本节开始 使用静态常量类声明交换机类型等
 * 该消费者 定义 接收direct-exchange 信道为 Q2 且路由key为error 的信息
 * @author: linsz
 * @create: 2022-07-16 17:21
 **/
public class Consumer2 {

    private static final String QueueName = "Q2";

    public static void main(String[] args) throws Exception {
        Channel channel = AmqpUtils.getChannel();
        channel.exchangeDeclare(ExchangeConstant.DirectExchange, BuiltinExchangeType.DIRECT);
        channel.queueDeclare(QueueName, false, false, false, null);
        channel.queueBind(QueueName, ExchangeConstant.DirectExchange, "error");

        System.out.println("这是消费者2号，接收error的信息");
        channel.basicConsume(QueueName, (consumerTag, message) -> {
            System.out.println("queueName、routerKey为：" + QueueName + " " + message.getEnvelope().getRoutingKey() + "内容为：" + new String(message.getBody()));
        }, consumerTag -> {
            System.out.println("这是消费者2失败的回调函数");
        });
    }
}
