package com.lin.rabbitmq.controller;

import com.lin.rabbitmq.constant.ExchangeConstant;
import com.lin.rabbitmq.constant.RoutingKeyConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @program: rabbitmq-springboot
 * @description: 基于插件的延迟队列
 * @author: linsz
 * @create: 2022-07-19 00:22
 **/
@RestController
@Slf4j
@RequestMapping("/send")
public class DelayQueueBasedPluginsController {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @PostMapping("/delay/{time}/{message}")
    public void delayQueueProducer(@PathVariable String message, @PathVariable String time) {
        rabbitTemplate.convertAndSend(ExchangeConstant.DelayCustomerExchange,
                RoutingKeyConstant.DelayCustomerRoutingKey,
                message, msg -> {
                    int delay = Integer.parseInt(time) * 1000;
                    msg.getMessageProperties().setDelay(delay);
                    return msg;
                });
        log.info("在时间:{},发送延迟时间为：{},延迟队列发送消息:{}", LocalDateTime.now(), time, message);

    }
}
