package com.lin.springsecurity.springmvc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @program: springsecurity
 * @description: User 实体类
 * @author: linsz
 * @create: 2022-10-24 18:25
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * id
     */
    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 全名
     */
    private String fullName;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 权限(模拟有几种权限)
     */
    private Set<String> authorities;

}
