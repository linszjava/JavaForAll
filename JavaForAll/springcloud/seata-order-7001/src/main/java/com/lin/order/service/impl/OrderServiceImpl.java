package com.lin.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.order.entities.Order;
import com.lin.order.mapper.OrderMapper;
import com.lin.order.openfeign.AccountOpenfeignService;
import com.lin.order.openfeign.StorageOpenfeignService;
import com.lin.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
* @author linsz
* @description 针对表【t_order】的数据库操作Service实现
* @createDate 2022-09-02 11:29:38
*/
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StorageOpenfeignService storageService;

    @Autowired
    private AccountOpenfeignService accountService;

    @Override
    @GlobalTransactional(name = "order-tx-test",rollbackFor = Exception.class)
    public void createOrder(Order order) {
        //1. 下订单
        log.info("开始下订单 》》》》》》》》");
        order.setStatus(0);
        log.info("order:======>{}",order);
        orderMapper.insert(order);
        log.info("结束下订单 《《《《《《《《《");

        //2. 减掉库存
        log.info("开始减库存 》》》》》》》》》");
        storageService.decreaseStorage(order.getProductId(), order.getCount());
        log.info("结束减库存 《《《《《《《《《《");
        //3.扣金额
        log.info("开始扣账户金额 》》》》》》 ");
        accountService.getDecreaseMoney(order.getUserId(),order.getMoney());
        log.info("结束扣账户金额 《《《《《《 ");
        //4. 更新订单状态信息
        UpdateWrapper<Order> orderUpdateWrapper = new UpdateWrapper<>();
        orderUpdateWrapper.set(Objects.nonNull(order.getStatus())&& order.getStatus()==0,
                "status",1);
        orderMapper.update(order,orderUpdateWrapper);
        log.info("完成订单更新状态 《《《《《《《《《《");


    }
}




