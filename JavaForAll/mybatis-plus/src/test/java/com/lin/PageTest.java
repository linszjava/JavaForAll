package com.lin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.mapper.UserMapper;
import com.lin.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: mybatisplus-springboot
 * @description: 分页测试类
 * @author: linsz
 * @create: 2022-07-29 06:49
 **/
@SpringBootTest
public class PageTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMyPage(){
        userMapper.selectAllByAgeUserPage(new Page<User>(1,3),30);
    }
}
