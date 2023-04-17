package com.lin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @program: mybatis-plus
 * @description: user接口类
 * @author: linsz
 * @create: 2022-07-27 10:24
 **/

public interface UserMapper extends BaseMapper<User> {

//    Map<String,Object> selectByIdMap(@Param("id")Long id);

    Page<User> selectAllByAgeUserPage( Page<User> page, @Param("age") Integer age);
}
