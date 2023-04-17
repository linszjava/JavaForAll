package com.lin.type.dead;

import com.lin.constant.ExchangeConstant;
import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.nio.charset.StandardCharsets;

/**
 * @program: rabbitmq
 * @description: 测试生产者 可能因为某种情况造成死信：情况1：TTL过期
 * @author: linsz
 * @create: 2022-07-17 07:56
 **/
public class Producer {

    public static void main(String[] args) throws Exception {
        Channel channel = AmqpUtils.getChannel();

        channel.exchangeDeclare(ExchangeConstant.NormalDirectExchange, BuiltinExchangeType.DIRECT);
        //注意：不要在生产端再次声明队列和队列绑定 会出错
//        channel.queueDeclare(QueueConstant.NormalQueue,false,false,false,null);

//        AMQP.BasicProperties props = new AMQP.BasicProperties().builder()
//                .expiration("10000").build();
//        //注意：不要在生产端再次声明队列和队列绑定 会出错
//        channel.queueBind(QueueConstant.NormalQueue, ExchangeConstant.NormalDirectExchange,"normal-routing-key");

        for (int i = 0; i < 10; i++) {
            System.out.println("info" + i);
            channel.basicPublish(ExchangeConstant.NormalDirectExchange, "normal-routing-key", null, String.valueOf(i).getBytes(StandardCharsets.UTF_8));

        }
    }
}
