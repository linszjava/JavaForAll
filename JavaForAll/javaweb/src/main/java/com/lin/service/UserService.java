package com.lin.service;

import com.lin.mapper.UserMapper;
import com.lin.pojo.User;
import com.lin.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * @program: JavaForAll
 * @description: UserService的接口实现类 此处就不规范声明接口再实现
 * @author: linsz
 * @create: 2022-06-20 17:52
 **/
public class UserService {
    private static SqlSession sqlSession;
    private static UserMapper mapper;

    static {
        try {
            sqlSession = SqlSessionUtil.getSqlSessionWithTrue();
            mapper = sqlSession.getMapper(UserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public User selectUser(String username, String password) throws IOException {
        User user = mapper.selectUser(username, password);
        return user;
    }

    public User selectByUserByUsername(String name) {
        User user = mapper.selectUserByUsername(name);
        return user;
    }

    public void addUser(User user) {
        mapper.add(user);
    }
}
