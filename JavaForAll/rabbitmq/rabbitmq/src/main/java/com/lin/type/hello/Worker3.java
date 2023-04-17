package com.lin.type.hello;

import com.lin.utils.AmqpUtils;
import com.lin.utils.SleepUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.nio.charset.Charset;

/**
 * @program: rabbitmq
 * @description: 测试手动应答的ack
 * <p>
 * basicConsume(String queue, boolean autoAck,  --->测试这个参数
 * DeliverCallback deliverCallback, CancelCallback cancelCallback)
 * @author: linsz
 * @create: 2022-07-12 05:28
 **/
public class Worker3 {

    public static final String QUEUE_NAME = "ACK_QUEUE";

    public static void main(String[] args) throws Exception {
        Connection connection = AmqpUtils.getConnection();
        Channel channel = connection.createChannel();

        // 设置该队列处理消息的时间长，并且在发生异常或者中断的时候，返回之前消费的消息到消息队列
        // 并且此处我们让 worker3完成消费
        System.out.println("我是worker3------------->>>>");
        channel.basicQos(3);
        channel.basicConsume(QUEUE_NAME, false,
                (consumerTag, message) -> {
                    SleepUtils.sleep(2);
                    System.out.println(new String(message.getBody(), Charset.defaultCharset()));
                    System.out.println("=====》" + consumerTag);
                    channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
                },
                consumerTag -> System.out.println(consumerTag + "返回消息异常"));
    }
}
