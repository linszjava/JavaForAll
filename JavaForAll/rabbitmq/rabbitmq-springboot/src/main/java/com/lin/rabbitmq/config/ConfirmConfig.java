package com.lin.rabbitmq.config;

import com.lin.rabbitmq.constant.ExchangeConstant;
import com.lin.rabbitmq.constant.QueueConstant;
import com.lin.rabbitmq.constant.RoutingKeyConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rabbitmq-springboot
 * @description: 发布确认配置类
 * @author: linsz
 * @create: 2022-07-19 03:44
 **/
@Configuration
public class ConfirmConfig {

    /**
     * 发布确认队列
     *
     * @return
     */
    @Bean
    public Queue confirmQueue() {
        return new Queue(QueueConstant.ConfirmQueue, false, false, false);
    }

    /**
     * 发布确认交换机  alternate:指名要fanout类型的交换机
     *
     * @return
     */
    @Bean
    public DirectExchange confirmExchange() {
        return ExchangeBuilder.directExchange(ExchangeConstant.ConfirmExchange)
                .durable(false).alternate(ExchangeConstant.BackUpExchange).build();
    }

    /**
     * 绑定发布确认交换机和队列
     *
     * @return
     */
    @Bean
    public Binding confirmQueueAndExchange() {
        return BindingBuilder.bind(confirmQueue())
                .to(confirmExchange()).with(RoutingKeyConstant.ConfirmRoutingKey);
    }
}
