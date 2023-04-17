package com.lin.rabbitmq.config;

import com.lin.rabbitmq.constant.ExchangeConstant;
import com.lin.rabbitmq.constant.QueueConstant;
import com.lin.rabbitmq.constant.RoutingKeyConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.image.DirectColorModel;
import java.util.HashMap;

/**
 * @program: rabbitmq-springboot
 * @description: 基于插件的延迟队列
 * @author: linsz
 * @create: 2022-07-18 23:58
 **/
@Configuration
public class DelayRabbitmqConfig {

    /**
     * 声明延迟队列
     *
     * @return
     */
    @Bean
    public Queue delayQueue() {
        return new Queue(QueueConstant.DelayQueue,
                true, false, false);
    }

    /**
     * 声明延迟自定义交换机类型
     *
     * @return
     */
    @Bean
    public CustomExchange delayCustomExchange() {
        HashMap<String, Object> args = new HashMap<>();
//        设置 x-delayed-type 为 direct，当然也可以是 topic 等 发送消息时设置消息头 headers 的 x-delay 属性，即延迟时间，如果不设置消息将会立即投递
        args.put("x-delayed-type", "direct");
        return new CustomExchange(ExchangeConstant.DelayCustomerExchange,
                "x-delayed-message", true, false, args);
    }

    /**
     * 绑定延迟交换机和队列
     *
     * @return
     */
    @Bean
    public Binding delayQueueAndCustomExchange() {
        return BindingBuilder.bind(delayQueue())
                .to(delayCustomExchange()).with(RoutingKeyConstant.DelayCustomerRoutingKey).noargs();
    }
}
