package com.lin.rabbitmq.controller;

import com.lin.rabbitmq.constant.ExchangeConstant;
import com.lin.rabbitmq.constant.RoutingKeyConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: rabbitmq-springboot
 * @description: 发布确认控制层
 * @author: linsz
 * @create: 2022-07-19 03:57
 **/
@RestController
@Slf4j
@RequestMapping("/confirm")
public class ConfirmController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/{message}")
    public void testConfirm(@PathVariable String message) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(ExchangeConstant.ConfirmExchange, RoutingKeyConstant.ConfirmRoutingKey,
                message, correlationData);

        log.info("发布确认交换机为:{},消息为:{}", ExchangeConstant.ConfirmExchange, message);
        //以下模拟发送到一个未知的交换机
        correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(ExchangeConstant.ConfirmExchange + "_unknown", RoutingKeyConstant.ConfirmRoutingKey,
                message, correlationData);

        log.info("发布确认交换机为:{},消息为:{}", ExchangeConstant.ConfirmExchange + "_unknown", message + "_unknown");
        //以下模拟发送到一个未知的队列上
        correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(ExchangeConstant.ConfirmExchange, RoutingKeyConstant.ConfirmRoutingKey + "_unknown",
                message, correlationData);

        log.info("发布确认交换机为:{},消息为:{}", RoutingKeyConstant.ConfirmRoutingKey + "_unknown", message + "_unknown");

    }
}
