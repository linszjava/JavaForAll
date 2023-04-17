package com.lin.spring.bean;

import com.lin.spring.pojo.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @program: JavaForAll
 * @description: FactoryBean测试  自定义返回的bean类型
 * @author: linsz
 * @create: 2022-06-24 04:07
 **/
public class MyBean implements FactoryBean<Course> {
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCourseName("Java基础");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
