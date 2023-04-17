package com.lin.springsecurity.springmvc.dto;

import lombok.Data;

/**
 * @program: springsecurity
 * @description: userDto
 * @author: linsz
 * @create: 2022-10-24 18:24
 **/
@Data
public class UserDto {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
