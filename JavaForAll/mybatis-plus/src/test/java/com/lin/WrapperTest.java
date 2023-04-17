package com.lin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.enums.SexEnum;
import com.lin.mapper.UserMapper;
import com.lin.pojo.User;
import com.lin.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @program: mybatisplus-springboot
 * @description: wrapper测试
 * @author: linsz
 * @create: 2022-07-28 10:09
 **/
@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testLoginDelete(){
        userService.removeBatchByIds(Arrays.asList(1552412092080877570l,1552412927611408386l));
    }

    @Test
    public void testShowAll(){
        userService.list().forEach(System.out::println);
    }

    @Test
    public void testQueryWrapper(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("name","linsz")
                .gt("age",25).orderByDesc("id");
        userService.list(userQueryWrapper).forEach(System.out::println);
    }

    @Test
    public void testDeleteByWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email"," ");
        userService.remove(wrapper);
    }

    @Test
    public void testUpdate(){
        User user = new User(null, "林谦", 34, "linqian@gmail.com", SexEnum.MALE, 0);
        userService.update(user,new UpdateWrapper<User>().gt("age",26));
    }

    @Test
    public void testConditionOrder(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id,name,email")
                .ge("age",23)
                .or()
                .isNull("email");

        userService.list(queryWrapper);
    }

    @Test
    public void testConditionOrder2(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("age",40)
         .or(userQueryWrapper1 -> userQueryWrapper1.isNull("email"));
//        .isNull("email");
        userService.list(userQueryWrapper);
    }

    @Test
    public void testSubQuery(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        QueryWrapper<User> ids = userQueryWrapper.inSql("id", "select id from t_user where id <10");
        userService.list(ids);
    }

    @Test
    public void testCondition(){
        String username = "林谦";
        Integer ageBegin = 25;
        Integer ageEnd = 30;

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq(StringUtils.isNotBlank(username),"name","林谦")
               // .or()
                .ge(ageBegin!=null,"age",ageBegin)
                .le(ageEnd!=null,"age",ageEnd);
        userService.list(userQueryWrapper);
    }

    @Test
    public void testLambda(){
        String username = "a";
        Integer ageBegin = 25;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(username), User::getName,username)
                .ge(ageBegin != null, User::getAge,ageBegin)
                .le(User::getAge,ageEnd);
        userMapper.selectList(lambdaQueryWrapper);
    }

    @Test
    public void testPage(){
        Page<User> userPage = new Page<>(1,3);
        Page<User> page = userMapper.selectPage(userPage, null);
//        如果此前没加分页插件配置 则为全查所有记录
        System.out.println("记录为："+page.getRecords());
    }
}
