package com.lin.rabbitmq.constant;

/**
 * @program: rabbitmq-springboot
 * @description: 路由key常量
 * @author: linsz
 * @create: 2022-07-18 06:40
 **/
public class RoutingKeyConstant {

    /**
     * 连接死信交换机的routingKey
     */
    public static final String DeadLetterRoutingKey = "YD";

    /**
     * 连接普通交换机的routingKey
     */
    public static final String CommonQueueRoutingKey = "common-queue-routing-key";


    /**
     * 延迟队列和交换机之间的RoutingKey
     */
    public static final String DelayCustomerRoutingKey = "delay-customer-routing-key";

    /**
     * 发布确认队列和路由器的routingKey
     */
    public static final String ConfirmRoutingKey = "confirm-routing-key";


}
