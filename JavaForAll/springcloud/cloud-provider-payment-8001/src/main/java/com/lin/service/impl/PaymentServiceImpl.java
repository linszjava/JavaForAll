package com.lin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.common.entities.Payment;
import com.lin.service.PaymentService;
import com.lin.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

/**
* @author linsz
* @description 针对表【payment】的数据库操作Service实现
* @createDate 2022-08-11 20:34:21
*/
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment>
    implements PaymentService{

}




