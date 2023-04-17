package com.lin.mapper;

import com.lin.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @program: JavaForAll
 * @description: UserMapper 接口
 * @author: linsz
 * @create: 2022-06-19 20:08
 **/
public interface UserMapper {

    /**
     * 根据用户名和密码查询是否匹配
     *
     * @param username
     * @param password
     */
    User selectUser(@Param("username") String username, @Param("password") String password);

    /**
     * 注册用户
     *
     * @param user
     */
    void add(User user);

    User selectUserByUsername(String username);


}
