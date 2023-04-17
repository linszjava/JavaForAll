package com.lin.type.hello;

import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeoutException;

/**
 * @program: rabbitmq
 * @description: 发布确认三种方式测试   在生产者方实现
 * @author: linsz
 * @create: 2022-07-13 06:03
 **/
public class ConfirmMessage {

    public static final int MessageCount = 1000;

    public static void main(String[] args) throws IOException, InterruptedException, TimeoutException {

        //1. 单个确认
        //单个发布确认合计时间为1349ms
//        confirmMessageSingle();
//        2.批量确认
//        批量发布确认合计时间为100ms
        //confirmMessageBatch();
//        3. 异步确认
//        异步确认合计时间为21ms
        confirmMessageAsync();

    }

    public static void confirmMessageSingle() throws IOException, TimeoutException, InterruptedException {
        String queueName = UUID.randomUUID().toString();
        Channel channel = AmqpUtils.getConnection().createChannel();
        channel.queueDeclare(queueName, true, false, false, null);
        //发布确认
        channel.confirmSelect();

        long start = System.currentTimeMillis();
        for (int i = 0; i < MessageCount; i++) {

            channel.basicPublish("", queueName,
                    MessageProperties.PERSISTENT_TEXT_PLAIN, String.valueOf(i).getBytes(StandardCharsets.UTF_8));

            boolean flag = channel.waitForConfirms();
            if (flag) {
                System.out.println("单个发布确认成功" + i);
            }

        }
        long end = System.currentTimeMillis();

        System.out.println("单个发布确认合计时间为" + (end - start) + "ms");


    }

    public static void confirmMessageBatch() throws IOException, TimeoutException, InterruptedException {
        String queueName = UUID.randomUUID().toString();
        Channel channel = AmqpUtils.getConnection().createChannel();
        channel.queueDeclare(queueName, true, false, false, null);
        //发布确认
        channel.confirmSelect();

        long start = System.currentTimeMillis();
        for (int i = 0; i < MessageCount; i++) {

            channel.basicPublish("", queueName,
                    MessageProperties.PERSISTENT_TEXT_PLAIN, String.valueOf(i).getBytes(StandardCharsets.UTF_8));

            //100条批量确认
            if (i % 99 == 0) {
                channel.waitForConfirms();
            }

        }
        long end = System.currentTimeMillis();

        System.out.println("批量发布确认合计时间为" + (end - start) + "ms");


    }

    public static void confirmMessageAsync() throws IOException, TimeoutException, InterruptedException {
        String queueName = UUID.randomUUID().toString();
        Channel channel = AmqpUtils.getConnection().createChannel();

        ConcurrentSkipListMap<Long, String> outerConfirm = new ConcurrentSkipListMap<>();
        channel.queueDeclare(queueName, true, false, false, null);
        //发布确认
        channel.confirmSelect();
        //addConfirmListener(ConfirmCallback ackCallback, ConfirmCallback nackCallback);
        channel.addConfirmListener((deliveryTag, multiple) -> {
                    if (multiple) {
                        ConcurrentNavigableMap<Long, String> headMap = outerConfirm.headMap(deliveryTag, true);
                        headMap.clear();
                    } else {
                        outerConfirm.remove(deliveryTag);
                    }

                },
//                未成功确认
                (deliveryTag, multiple) -> {
                    //  String message = outerConfirm.get(deliveryTag);
                    //  System.out.println("未能成功确认的消息:"+message);

                });
        long start = System.currentTimeMillis();
        for (int i = 0; i < MessageCount; i++) {
//            System.out.println("发送消息:"+i);
            outerConfirm.put(channel.getNextPublishSeqNo(), String.valueOf(i));
            channel.basicPublish("", queueName,
                    MessageProperties.PERSISTENT_TEXT_PLAIN, String.valueOf(i).getBytes(StandardCharsets.UTF_8));

        }
        long end = System.currentTimeMillis();

        System.out.println("异步确认合计时间为" + (end - start) + "ms");


    }
}
