package com.lin.type.hello;

import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: rabbitmq
 * @description: 工作队列 消费者测试
 * @author: linsz
 * @create: 2022-07-12 04:38
 **/
public class Worker1 {

    private static final String QUEUE_NAME = "HELLO";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = AmqpUtils.getConnection();
        Channel channel = connection.createChannel();
//        basicConsume(String queue, boolean autoAck, DeliverCallback deliverCallback,
        System.out.println("工作队列2，在等待消息...");
        channel.basicConsume(QUEUE_NAME, true,
                (consumerTag, message) -> System.out.println(new String(message.getBody())),
                consumerTag -> System.out.println(consumerTag + "消费者异常"));
    }
}
