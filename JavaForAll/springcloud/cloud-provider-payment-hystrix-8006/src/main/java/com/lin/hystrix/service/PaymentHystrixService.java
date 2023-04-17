package com.lin.hystrix.service;

import com.lin.common.result.CommonResult;

import java.util.HashMap;

/**
 * @program: springcloud
 * @description: hystrix service 接口类
 * @author: linsz
 * @create: 2022-08-21 15:56
 **/
public interface PaymentHystrixService {

    /**
     * 模拟测试成功测试返回
     * @param id
     * @return
     */
    CommonResult paymentInfo_OK(Integer id);

    /**
     * 模拟测试超时
     * @param id
     * @return
     */
    CommonResult  paymentInfo_Fail(Integer id);

    /**
     * 模拟得到正数成功 负数失败 测试熔断
     * @param id
     * @return
     */
    CommonResult getRightId(Integer id);
}
