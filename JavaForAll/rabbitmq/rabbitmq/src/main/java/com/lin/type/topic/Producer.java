package com.lin.type.topic;

import com.lin.constant.ExchangeConstant;
import com.lin.constant.QueueConstant;
import com.lin.utils.AmqpUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: rabbitmq
 * @description: topic交换机生产者
 * @author: linsz
 * @create: 2022-07-17 01:07
 **/
public class Producer {

    public static void main(String[] args) throws Exception {
        Channel channel = AmqpUtils.getChannel();

        channel.exchangeDeclare(ExchangeConstant.TopicExchange, BuiltinExchangeType.TOPIC);
        //测试得知：在没有交换机，或者交换机的类型是direct 类型，可以在生产端不绑定队列而由客户端绑定即可，但是
//        在topic交换机中，如果只在消费端绑定队列，则在rabbitmq的可视化界面，依旧可以看到该队列被绑定，但是，消费者却无法得到消息，只有在生产端
//        同样也声明队列绑定，才能进行消息传递
        channel.queueBind(QueueConstant.TopicQueueName, ExchangeConstant.TopicExchange, "info.#");
        channel.queueBind(QueueConstant.TopicQueueName, ExchangeConstant.TopicExchange, "*.warning.*");
        channel.queueBind(QueueConstant.TopicQueueName_2, ExchangeConstant.TopicExchange, "info.*");

        HashMap<String, String> topicRouterKey = new HashMap<>();
        topicRouterKey.put("info.*", "该消息Consumer1-2都能接收得到");
        topicRouterKey.put("info.message.my", "该消息只有Consumer1能接收得到");
        topicRouterKey.put("my.warning.log", "该消息只有Consumer1能接收得到");

        System.out.println("生产者开始生产消息----》");
        for (Map.Entry<String, String> stringStringEntry : topicRouterKey.entrySet()) {
            channel.basicPublish(ExchangeConstant.TopicExchange, stringStringEntry.getKey(),
                    null, stringStringEntry.getValue().getBytes(StandardCharsets.UTF_8));
        }

        System.out.println("《-----生产者结束生产消息----》");
    }

}
