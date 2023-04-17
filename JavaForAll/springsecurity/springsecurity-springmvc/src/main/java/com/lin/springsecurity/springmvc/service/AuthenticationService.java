package com.lin.springsecurity.springmvc.service;

import com.lin.springsecurity.springmvc.dto.UserDto;
import com.lin.springsecurity.springmvc.pojo.User;

/**
 * @program: springsecurity
 * @description: 认证接口 service层
 * @author: linsz
 * @create: 2022-10-24 18:22
 **/
public interface AuthenticationService {

    /**
     * 用户认证
     */
    User authentication(UserDto userDto);
}
