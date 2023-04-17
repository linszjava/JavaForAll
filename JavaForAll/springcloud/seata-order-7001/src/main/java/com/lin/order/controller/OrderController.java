package com.lin.order.controller;

import com.lin.common.result.CommonResult;
import com.lin.order.entities.Order;
import com.lin.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud
 * @description: order 控制层
 * @author: linsz
 * @create: 2022-09-05 23:41
 **/
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order/addOrder")
    public CommonResult createOrder(@RequestBody Order order){
        orderService.createOrder(order);
        return new CommonResult(666,"下订单成功",order);
    }
}
