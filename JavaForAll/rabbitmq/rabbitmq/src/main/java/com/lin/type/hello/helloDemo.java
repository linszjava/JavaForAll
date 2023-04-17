package com.lin.type.hello;

import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @program: rabbitmq
 * @description: 简单模式的测试
 * @author: linsz
 * @create: 2022-07-12 00:30
 **/
public class helloDemo {

    private static final String QUEUE_NAME = "HELLO";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = AmqpUtils.getConnection();
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("localhost");
//        factory.setUsername("guest");
//        factory.setPassword("guest");
//        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String message = "this is the first rabbitmq message";
//        queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//        basicPublish(String exchange, String routingKey, boolean mandatory, boolean immediate, BasicProperties props, byte[] body)
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
        System.out.println("生产者生产了一条数据");
    }


}
