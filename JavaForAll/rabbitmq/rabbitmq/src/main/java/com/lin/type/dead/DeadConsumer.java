package com.lin.type.dead;

import com.lin.constant.ExchangeConstant;
import com.lin.constant.QueueConstant;
import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

/**
 * @program: rabbitmq
 * @description: 死信队列的消费者消费信息
 * @author: linsz
 * @create: 2022-07-17 07:51
 **/
public class DeadConsumer {

    public static void main(String[] args) throws Exception {
        Channel channel = AmqpUtils.getChannel();
        System.out.println("这是死信队列中的消费者");
        channel.exchangeDeclare(ExchangeConstant.DeadExchange, BuiltinExchangeType.DIRECT);
        channel.queueDeclare(QueueConstant.DeadQueue, false, false, false, null);
        channel.queueBind(QueueConstant.DeadQueue, ExchangeConstant.DeadExchange, "dead-routing-key");
        channel.basicConsume(QueueConstant.DeadQueue, true, (consumerTag, message) -> {
            System.out.println(QueueConstant.DeadQueue + ":" + message.getEnvelope().getRoutingKey() + ":" + new String(message.getBody()));

        }, consumerTag -> {
            System.out.println("死信队列消费者的消费失败回调函数");
        });
    }

}
