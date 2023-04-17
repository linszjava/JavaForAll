package com.lin.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.order.entities.Order;

/**
* @author linsz
* @description 针对表【t_order】的数据库操作Service
* @createDate 2022-09-02 11:29:38
*/
public interface OrderService extends IService<Order> {

    void createOrder(Order order);

}
