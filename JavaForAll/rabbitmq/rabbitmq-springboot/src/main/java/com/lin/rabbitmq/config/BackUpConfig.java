package com.lin.rabbitmq.config;

import com.lin.rabbitmq.constant.ExchangeConstant;
import com.lin.rabbitmq.constant.QueueConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rabbitmq-springboot
 * @description: 备份交换机配置类 ::注意与ConfirmConfig中的一些队列和交换机共同使用
 * @author: linsz
 * @create: 2022-07-19 05:30
 **/
@Configuration
public class BackUpConfig {

    /**
     * 声明备份队列
     *
     * @return
     */
    @Bean
    public Queue backUpQueue() {
        return new Queue(QueueConstant.BackUpQueue, false, false, false);
    }

    /**
     * 声明警告交换机
     *
     * @return
     */
    @Bean
    public Queue warningQueue() {
        return new Queue(QueueConstant.WarningQueue, false, false, false);
    }

    /**
     * 声明备份交换机
     *
     * @return
     */
    @Bean
    public FanoutExchange backUpExchange() {
        return ExchangeBuilder.fanoutExchange(ExchangeConstant.BackUpExchange)
                .build();
    }

    /**
     * 绑定backup-exchange和backup-queue
     *
     * @return
     */
    @Bean
    public Binding backUpQueueAndExchange() {
        return BindingBuilder.bind(backUpQueue()).to(backUpExchange());
    }

    /**
     * 绑定backup-exchange和warning-queue
     *
     * @return
     */
    @Bean
    public Binding warningQueueAndExchange() {
        return BindingBuilder.bind(warningQueue()).to(backUpExchange());
    }

    /**
     * 注意：修改ConfirmConfig 中的confirm-exchange,使其当消息无法投递时，发送给备份交换机
     */


}
