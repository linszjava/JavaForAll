package com.lin.spring.tx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @program: JavaForAll
 * @description: 事务测试 account 实体类
 * @author: linsz
 * @create: 2022-06-25 02:55
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Account {

    private Integer id;
    private String name;
    private Double balance;
}
