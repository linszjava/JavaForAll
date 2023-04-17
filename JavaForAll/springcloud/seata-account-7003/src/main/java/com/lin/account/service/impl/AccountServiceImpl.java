package com.lin.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.account.entities.Account;
import com.lin.account.service.AccountService;
import com.lin.account.mapper.AccountMapper;
import com.lin.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
* @author linsz
* @description 针对表【t_account】的数据库操作Service实现
* @createDate 2022-09-02 16:42:23
*/
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
    implements AccountService{

    @Autowired
    private AccountMapper accountMapper;

    /**
     * 根据用户id 进行账户余额的扣减
     * @param userId
     * @param money
     */
    @Override
    public void decreaseMoney(Long userId, BigDecimal money) {
        log.info("account: 开始扣减账户中的金额》》》》》》 ");
        Account account = accountMapper.selectById(userId);
        // 不考虑数据溢出等问题 只测试
        account.setUsed(account.getUsed().add(money))
                .setResidue(account.getResidue().subtract(money));

        log.info("account: 扣减账户中的金额完毕 》》》》》》 ");

    }
}




