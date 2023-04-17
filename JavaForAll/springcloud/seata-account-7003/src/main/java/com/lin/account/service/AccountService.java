package com.lin.account.service;

import com.lin.account.entities.Account;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
* @author linsz
* @description 针对表【t_account】的数据库操作Service
* @createDate 2022-09-02 16:42:23
*/
public interface AccountService extends IService<Account> {

    void decreaseMoney(Long userId, BigDecimal money);

}
