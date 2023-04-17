package com.lin.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @program: Java-Ultimate
 * @description: Account 实体类
 * @author: linsz
 * @create: 2022-06-17 01:42
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Account {

    private int id;

    private String name;

    private double balance;
}
