package com.lin.type.fanout;

import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: rabbitmq
 * @description: 消费者测试1
 * @author: linsz
 * @create: 2022-07-16 00:37
 **/
public class Consumer1 {

    public static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = AmqpUtils.getConnection().createChannel();
        String queueName = channel.queueDeclare().getQueue();
        //指定一个交换机和类型
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
//        指定消费者绑定到那个队列上面
        channel.queueBind(queueName, EXCHANGE_NAME, "");
        System.out.println("我是消费者1：在等待消息");
        channel.basicConsume(queueName, true, (consumerTag, message) -> {

            String msg = new String(message.getBody());
            System.out.println("生产者发布的消息是：" + msg);

        }, consumerTag -> {

        });
    }
}
