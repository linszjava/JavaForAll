package com.lin.rabbitmq.service;

import com.lin.common.result.CommonResult;

/**
 * @program: springcloud
 * @description: 消息发送接口
 * @author: linsz
 * @create: 2022-08-24 14:20
 **/
public interface MessageService {

    CommonResult sendMessage();
}
