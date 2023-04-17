package com.lin.rabbitmq.constant;

/**
 * @program: rabbitmq-springboot
 * @description: 交换机常量
 * @author: linsz
 * @create: 2022-07-18 03:25
 **/
public class ExchangeConstant {
    /**
     * 直连交换机 direct-exchange
     */
    public static final String DirectExchange = "direct-exchange";

    /**
     * 死信交换机： dead-exchange
     */
    public static final String DeadExchange = "dead-exchange";

    /**
     * 基于插件的自定义延迟交换机类型
     */
    public static final String DelayCustomerExchange = "delay-exchange";


    /**
     * 发布确认交换机
     */
    public static final String ConfirmExchange = "confirm-exchange";

    /**
     * 备份交换机  type:fanout
     */
    public static final String BackUpExchange = "backup-exchange";

}
