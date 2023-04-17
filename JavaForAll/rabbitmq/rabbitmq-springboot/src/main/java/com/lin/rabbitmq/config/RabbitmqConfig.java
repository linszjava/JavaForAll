package com.lin.rabbitmq.config;

import com.lin.rabbitmq.constant.ExchangeConstant;
import com.lin.rabbitmq.constant.QueueConstant;
import com.lin.rabbitmq.constant.RoutingKeyConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rabbitmq-springboot
 * @description: rabbitmq配置类
 * @author: linsz
 * @create: 2022-07-18 03:24
 **/
@Configuration
public class RabbitmqConfig {

    /**
     * 声明direct交换机 DirectExchange
     *
     * @return
     */
    @Bean
    public DirectExchange declareNormalDirectExchange() {
        return new DirectExchange(ExchangeConstant.DirectExchange,
                true, false, null);
    }

    /**
     * 声明direct 死信交换机 DeadExchange
     *
     * @return
     */
    @Bean
    public DirectExchange declareDeadExchange() {
        return new DirectExchange(ExchangeConstant.DeadExchange,
                true, false, null);
    }

    /**
     * 声明延迟队列QA 声明过期时间为10s,死信交换机为 DeadExchange 死信路由key为 YD
     *
     * @return
     */
    @Bean
    public Queue declareQueueQA() {
        return QueueBuilder.durable(QueueConstant.DelayQueueA)
                .ttl(10000)
                .deadLetterExchange(ExchangeConstant.DeadExchange)
                .deadLetterRoutingKey("YD").build();
    }

    /**
     * 声明延迟队列QB 声明过期时间为40s,死信交换机为 DeadExchange 死信路由key为 YD
     *
     * @return
     */
    @Bean
    public Queue declareQueueQB() {
        return QueueBuilder.durable(QueueConstant.DelayQueueB)
                .ttl(40000)
                .deadLetterExchange(ExchangeConstant.DeadExchange)
                .deadLetterRoutingKey("YD").build();
    }

    /**
     * 声明死信队列QD
     *
     * @return
     */
    @Bean
    public Queue declareQueueQD() {
        return QueueBuilder.durable(QueueConstant.DeadQueue)
                .deadLetterExchange(ExchangeConstant.DeadExchange)
                .deadLetterRoutingKey("YD")
                .build();
    }

    /**
     * 绑定队列QA的路由器 路由key为XA
     *
     * @return
     */
    @Bean
    public Binding bindingNormalExchangeAndQueueA() {
        return BindingBuilder.bind(declareQueueQA())
                .to(declareNormalDirectExchange())
                .with("XA");
    }

    /**
     * 绑定队列QB的路由器 路由key为XB
     *
     * @return
     */
    @Bean
    public Binding bindingNormalExchangeAndQueueB() {
        return BindingBuilder.bind(declareQueueQB())
                .to(declareNormalDirectExchange())
                .with("XB");
    }

    /**
     * 绑定死信交换机和其死信队列
     *
     * @return
     */
    @Bean
    public Binding bindingDeadExchangeAndQueueD() {
        return BindingBuilder.bind(declareQueueQD())
                .to(declareDeadExchange())
                .with("YD");
    }

    /**
     * 声明普通队列
     *
     * @return
     */
    @Bean
    public Queue declareCommonQueue() {
        return QueueBuilder.durable(QueueConstant.CommonQueue)
                .deadLetterExchange(ExchangeConstant.DeadExchange)
                .deadLetterRoutingKey(RoutingKeyConstant.DeadLetterRoutingKey)
                .build();
    }

    /**
     * 绑定交换机和普通队列
     *
     * @return
     */
    @Bean
    public Binding commonQueueWithExchange() {
        return BindingBuilder.bind(declareCommonQueue())
                .to(declareNormalDirectExchange()).with(RoutingKeyConstant.CommonQueueRoutingKey);
    }


}
