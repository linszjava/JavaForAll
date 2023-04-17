package com.lin.type.hello;

import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @program: rabbitmq
 * @description: 测试消息队列的原理：轮训机制
 * @author: linsz
 * @create: 2022-07-12 04:45
 **/
public class Producer {

    private static final String QUEUE_NAME = "HELLO";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = AmqpUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        System.out.println("生产者请生产产品：");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String message = scanner.nextLine();

            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
        }

    }
}
