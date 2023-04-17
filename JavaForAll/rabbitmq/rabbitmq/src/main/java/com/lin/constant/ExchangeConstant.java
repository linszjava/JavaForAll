package com.lin.constant;

/**
 * @program: rabbitmq
 * @description: 交换机的名字
 * @author: linsz
 * @create: 2022-07-16 17:27
 **/
public class ExchangeConstant {

    public static final String DirectExchange = "direct-exchange";

    public static final String TopicExchange = "topic-exchange";

    //普通交换机
    public static final String NormalDirectExchange = "normal-direct-exchange";

    //死信交换机
    public static final String DeadExchange = "dead-exchange";
}
