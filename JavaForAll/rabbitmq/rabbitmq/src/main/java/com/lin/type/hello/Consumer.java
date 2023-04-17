package com.lin.type.hello;

import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: rabbitmq
 * @description: 消费者测试
 * @author: linsz
 * @create: 2022-07-12 01:11
 **/
public class Consumer {

    private static final String QUEUE_NAME = "HELLO";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = AmqpUtils.getConnection();
        Channel channel = connection.createChannel();
//        basicConsume(String queue, boolean autoAck, DeliverCallback deliverCallback,
//        CancelCallback cancelCallback)
        DeliverCallback deliverCallback = (message, delivery) -> {
            String s = new String(delivery.getBody());
            System.out.println(s);
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, s -> System.out.println("消费者消费失败" + s));

    }
}
