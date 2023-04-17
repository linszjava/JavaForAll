package com.lin.type.dead;

import com.lin.constant.ExchangeConstant;
import com.lin.constant.QueueConstant;
import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.util.HashMap;

/**
 * @program: rabbitmq
 * @description: 死信测试 客户端：正常接收信息的消费者一
 * @author: linsz
 * @create: 2022-07-17 06:59
 **/
public class Consumer {

    public static void main(String[] args) throws Exception {
        Channel channel = AmqpUtils.getChannel();

        //死信交换机
        channel.exchangeDeclare(ExchangeConstant.DeadExchange, BuiltinExchangeType.DIRECT);
        //普通交换机
        channel.exchangeDeclare(ExchangeConstant.NormalDirectExchange, BuiltinExchangeType.DIRECT);
        channel.queueDeclare(QueueConstant.DeadQueue, false, false, false, null);
        channel.queueBind(QueueConstant.DeadQueue, ExchangeConstant.DeadExchange, "dead-routing-key");

        //正常队列绑定死信队列信息
        //在普通队列中声明，若发生死信，则把消息传送到哪一个交换机和其路由key
        HashMap<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", ExchangeConstant.DeadExchange);
        arguments.put("x-dead-letter-routing-key", "dead-routing-key");
//        arguments.put("x-message-ttl",10000);
//        模拟最大消费的长度为7，然后让生产者生产10，自然而然会有3个进入死信队列
//        修改了参数，记得重建队列
        arguments.put("x-max-length", 7);
        channel.queueDeclare(QueueConstant.NormalQueue,
                false, false, false, arguments);
        //队列绑定
        channel.queueBind(QueueConstant.NormalQueue, ExchangeConstant.NormalDirectExchange, "normal-routing-key");

        System.out.println("这是正常队列消费消息");
        channel.basicConsume(QueueConstant.NormalQueue, true, (consumerTag, message) -> {
            System.out.println(QueueConstant.NormalQueue + ":" + message.getEnvelope().getRoutingKey() + ":" + new String(message.getBody()));


        }, consumerTag -> {
            System.out.println("这是失败消费者1的回调函数");
        });
    }
}
