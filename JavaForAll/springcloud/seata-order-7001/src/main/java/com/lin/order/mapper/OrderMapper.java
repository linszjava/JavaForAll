package com.lin.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.order.entities.Order;
import org.apache.ibatis.annotations.Mapper;

/**
* @author linsz
* @description 针对表【t_order】的数据库操作Mapper
* @createDate 2022-09-02 11:29:38
* @Entity com.lin.order.entities.Order
*/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}




