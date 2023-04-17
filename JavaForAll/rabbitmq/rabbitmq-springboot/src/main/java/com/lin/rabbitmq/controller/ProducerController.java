package com.lin.rabbitmq.controller;

import com.lin.rabbitmq.constant.ExchangeConstant;
import com.lin.rabbitmq.constant.RoutingKeyConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @program: rabbitmq-springboot
 * @description: 模拟生产者发送消息的控制层
 * @author: linsz
 * @create: 2022-07-18 04:19
 **/
@RestController
@Slf4j
@RequestMapping("/delay")
public class ProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/ttl/{message}")
    public void sendMessage(@PathVariable("message") String message) {
        log.info("发送的时间为:{},消息内容为:{}", LocalDateTime.now(), message);
        rabbitTemplate.convertAndSend(ExchangeConstant.DirectExchange, "XA", "消息来自QA，ttl=10s" + message);
        rabbitTemplate.convertAndSend(ExchangeConstant.DirectExchange, "XB", "消息来自QB，ttl=40s" + message);
    }

    @PostMapping("/ttl/{time}/{message}")
    public void sendExpireTimeWithMessage(@PathVariable Integer time, @PathVariable String message) {

        rabbitTemplate.convertAndSend(ExchangeConstant.DirectExchange, RoutingKeyConstant.CommonQueueRoutingKey,
                message, msg -> {
                    int expiration = time * 1000;
                    msg.getMessageProperties().setExpiration(String.valueOf(expiration));
                    return msg;
                }
        );

        log.info("发送的时间为:{},延时时间为：{},消息内容为:{}", LocalDateTime.now(), time, message);

    }


}
