package com.lin;

import com.lin.enums.SexEnum;
import com.lin.mapper.UserMapper;
import com.lin.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: mybatisplus-springboot
 * @description: 枚举类测试
 * @author: linsz
 * @create: 2022-07-29 10:24
 **/
@SpringBootTest
public class EnumTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testAddWithEnum(){
        User user = new User();
        user.setName("enums").setAge(22).setSex(SexEnum.MALE).setEmail("enums@gmail.com");
        userMapper.insert(user);
    }
}
