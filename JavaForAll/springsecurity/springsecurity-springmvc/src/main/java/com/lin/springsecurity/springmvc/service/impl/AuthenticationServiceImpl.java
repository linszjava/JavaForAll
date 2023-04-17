package com.lin.springsecurity.springmvc.service.impl;

import com.lin.springsecurity.springmvc.dto.UserDto;
import com.lin.springsecurity.springmvc.pojo.User;
import com.lin.springsecurity.springmvc.service.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @program: springsecurity
 * @description: 认证实现类
 * @author: linsz
 * @create: 2022-10-24 18:27
 **/
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    /**
     * 用户认证
     *
     * @param userDto
     */
    @Override
    public User authentication(UserDto userDto) {
        if (Objects.isNull(userDto)
        || StringUtils.isEmpty(userDto.getUsername())
        || StringUtils.isEmpty(userDto.getPassword())){
            throw new RuntimeException("密码为空或者用户不存在");
        }
        // 如果userDto不空,有数据 但可能存在用户名或者密码错误的情况
        User user = getUser(userDto.getUsername());
        if (Objects.isNull(user)){
            throw new RuntimeException("查询不到该用户");
        }
        // 密码错误
        if (!userDto.getPassword().equals(user.getPassword())){
            throw new RuntimeException("密码错误");
        }
        return user;
    }

    /**
     * 模拟从数据库中加载数据
     */
     private static Map<String,User> userMap = new HashMap<>();
    static {
        Set<String> authoritiesP1 = new HashSet<>();
        Set<String> authoritiesP2 = new HashSet<>();
        authoritiesP1.add("p1");
        authoritiesP2.add("p2");
        // 模拟让张三有 R1 且可以访问 r/r1
        // 模拟让李四有 R2 且可以访问 r/r2
        userMap.put("zhangsan",new User("1111","zhangsan","123","张三","123123",authoritiesP1));
        userMap.put("lisi",new User("2222","lisi","123","李四","123124",authoritiesP2));
    }

    /**
     * 根据key值 获取user 模拟获得的user对象
     * @param username
     * @return
     */
    public User getUser(String username){
        return userMap.get(username);
    }
}
