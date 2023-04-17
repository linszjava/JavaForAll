package com.lin.type.hello;

import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @program: rabbitmq
 * @description: 测试手动应答的生产者
 * @author: linsz
 * @create: 2022-07-12 05:29
 **/
public class AckProducer {

    public static final String QUEUE_NAME = "ACK_QUEUE";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = AmqpUtils.getConnection();
        Channel channel = connection.createChannel();
        // durable 持久化到磁盘 ：true  队列持久化
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        System.out.println("生产者请生产产品：");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String message = scanner.nextLine();

            // 消息持久化 props MessageProperties.PERSISTENT_TEXT_PLAIN
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
        }

    }
}
