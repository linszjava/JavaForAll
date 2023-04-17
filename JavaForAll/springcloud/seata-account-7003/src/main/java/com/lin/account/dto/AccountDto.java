package com.lin.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @program: springcloud
 * @description: 前端账户传参
 * @author: linsz
 * @create: 2022-09-02 17:00
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AccountDto {

    private Long userId;

    /**
     * 传递金额参数  用于扣减
     */
    private BigDecimal money;
}
