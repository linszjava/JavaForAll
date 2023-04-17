package com.lin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: mybatisplus-springboot
 * @description: 性别枚举类
 * @author: linsz
 * @create: 2022-07-29 10:18
 **/
@Getter
@AllArgsConstructor
public enum SexEnum {

    MALE(1,"男"),
    FEMALE(0,"女");

    /**
     * 性别类型 1：男（默认） 0：女
     */
    @EnumValue
    private Integer type;

    /**
     * 性别类型
     */
    private String sexType;
}
