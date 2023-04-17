package com.lin;

import com.lin.pojo.User;
import com.lin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * @program: mybatisplus-springboot
 * @description: userService测试类
 * @author: linsz
 * @create: 2022-07-28 05:48
 **/
@SpringBootTest
public class MyTestAboutUserService {


    @Autowired
    private UserService userService;
    @Test
    public void testUserService(){
        userService.list().forEach(System.out::println);
        System.out.println(userService.count());
    }

    @Test
    public void testInsert(){
        User linss = new User().setAge(22).setEmail("kub@gmail.com").setName("linss");
        userService.save(linss);
    }
    @Test
    public void testSaveBatch(){

        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            User newUser = user.setAge(20 + i).setName("linsz" + i).setEmail("linsz" + i + "@gmail.com");
            list.add(newUser);
        }

        userService.saveBatch(list);
    }
}
