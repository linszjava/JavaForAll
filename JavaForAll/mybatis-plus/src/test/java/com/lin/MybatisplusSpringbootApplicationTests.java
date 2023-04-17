package com.lin;

import com.lin.mapper.UserMapper;
import com.lin.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MybatisplusSpringbootApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
        System.out.println("hello");
    }

    @Test
    public void testSelectAll(){
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testInset(){

       // userMapper.insert(new User(null,"linsz",23,"linszjava@gmail.com",0));
    }

    @Test
    public void testDelete(){
//        userMapper.deleteById(2l);
//        userMapper.deleteById(new User().setId(1l));
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","linsz");
        userMapper.deleteByMap(map);
    }

    @Test
    public void testUpdate(){
       // User user = new User(3l, "tom222", 24, "haha@qq.com",0);
       // userMapper.updateById(user);

    }
    @Test
    public void testSelect(){
//        System.out.println(userMapper.selectById(3l));
//        userMapper.selectMaps(null).forEach(System.out::println);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("id",4l);
//        System.out.println(userMapper.selectByMap(stringObjectHashMap));
        System.out.println(userMapper.selectBatchIds(Arrays.asList(3l, 4l, 5l)));
    }

    /**
     * 自定义sql语句
     */
    @Test
    public void testCustomer(){
//        Map<String, Object> map = userMapper.selectByIdMap(3l);
//        map.forEach((s, o) -> System.out.println(s+"::"+o));
    }


}
