package com.lin.account.controller;

import com.lin.account.dto.AccountDto;
import com.lin.account.entities.Account;
import com.lin.account.service.AccountService;
import com.lin.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @program: springcloud
 * @description: 账户控制层
 * @author: linsz
 * @create: 2022-09-02 16:57
 **/
@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/decreaseMoney")
    public CommonResult getDecreaseMoney(@RequestParam("userId") Long userId,
                                                  @RequestParam("money")BigDecimal money){
         accountService.decreaseMoney(userId, money);
            return new CommonResult<>(666,"账户扣除余额成功");
    }
}
