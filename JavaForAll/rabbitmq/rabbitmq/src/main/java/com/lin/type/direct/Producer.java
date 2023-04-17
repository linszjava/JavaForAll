package com.lin.type.direct;

import com.lin.constant.ExchangeConstant;
import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: rabbitmq
 * @description: direct-exchange的生产者
 * @author: linsz
 * @create: 2022-07-17 00:07
 **/
public class Producer {

    public static void main(String[] args) throws Exception {
        Channel channel = AmqpUtils.getChannel();
        channel.exchangeDeclare(ExchangeConstant.DirectExchange, BuiltinExchangeType.DIRECT);

        HashMap<String, String> routerKeyMap = new HashMap<>();
        routerKeyMap.put("info", "我是发送给Q1的info接收的22");
        routerKeyMap.put("warning", "我是发送给Q1的warning接收的22");
        routerKeyMap.put("error", "我是发送给Q2的error接收的22");

        for (Map.Entry<String, String> stringEntry : routerKeyMap.entrySet()) {
            channel.basicPublish(ExchangeConstant.DirectExchange, stringEntry.getKey(), null, stringEntry.getValue().getBytes(StandardCharsets.UTF_8));
        }
        System.out.println("生产者生产完毕");


    }
}
