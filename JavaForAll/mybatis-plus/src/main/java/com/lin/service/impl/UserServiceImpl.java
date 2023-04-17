package com.lin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.mapper.UserMapper;
import com.lin.pojo.User;
import com.lin.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @program: mybatisplus-springboot
 * @description: userService实现类
 * @author: linsz
 * @create: 2022-07-28 05:45
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
