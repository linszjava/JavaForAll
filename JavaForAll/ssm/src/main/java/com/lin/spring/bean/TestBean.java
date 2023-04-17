package com.lin.spring.bean;

/**
 * @program: JavaForAll
 * @description: 测试Bean的生命周期的七个过程
 * @author: linsz
 * @create: 2022-06-24 05:43
 **/
public class TestBean {

    private String name;

    public TestBean() {
        System.out.println("第一步：调用无参构造函数！");
    }

    public void setName(String name) {
        System.out.println("第二步：调用setter");
        this.name = name;
    }

    public void init() {
        System.out.println("第四步： 初始化");
    }

    public void destroy() {
        System.out.println("第七步： 销毁");
    }
}
