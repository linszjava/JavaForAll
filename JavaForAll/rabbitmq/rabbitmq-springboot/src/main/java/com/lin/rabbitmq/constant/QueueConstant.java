package com.lin.rabbitmq.constant;

/**
 * @program: rabbitmq-springboot
 * @description: 队列静态常量
 * @author: linsz
 * @create: 2022-07-18 03:26
 **/
public class QueueConstant {

    /**
     * 延迟队列1 ：QA
     */
    public static final String DelayQueueA = "QA";
    /**
     * 延迟队列2 ：QB
     */
    public static final String DelayQueueB = "QB";

    /**
     * 死信队列 ：QD
     */
    public static final String DeadQueue = "QD";

    /**
     * 普通队列 不设置其过期时间
     */
    public static final String CommonQueue = "common-queue";

    /**
     * 基于插件实现的延迟队列
     */
    public static final String DelayQueue = "delay-queue";

    /**
     * 发布确认队列
     */
    public static final String ConfirmQueue = "confirm-queue";

    /**
     * 备份队列
     */
    public static final String BackUpQueue = "backup-queue";

    /**
     * 警告队列
     */
    public static final String WarningQueue = "warning-queue";

}
