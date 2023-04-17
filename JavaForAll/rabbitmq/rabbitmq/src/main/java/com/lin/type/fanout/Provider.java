package com.lin.type.fanout;

import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @program: rabbitmq
 * @description: 交换机 扇出 fanout 生产者端
 * @author: linsz
 * @create: 2022-07-16 00:30
 **/
public class Provider {

    public static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = AmqpUtils.getConnection().createChannel();
//        声明是那种交换机类型
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        System.out.println("请输入生产者想要发布的消息：");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String message = scanner.nextLine();

//            路由key统一指定为空
            channel.basicPublish(EXCHANGE_NAME, "",
                    MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
        }

    }
}
