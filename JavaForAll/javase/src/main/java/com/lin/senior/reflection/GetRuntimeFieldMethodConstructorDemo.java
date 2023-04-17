package com.lin.senior.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: javase
 * @description: 获取运行时的属性对象构造器 并进行一顿操作
 * @author: linsz
 * @create: 2022-06-13 16:59
 **/
public class GetRuntimeFieldMethodConstructorDemo {

    @Test
    public void getSetField() throws Exception {
        Class<Human> humanClass = Human.class;
        Human human = humanClass.newInstance();
        Field desc = humanClass.getField("desc");
        desc.set(human, "linsz");
        System.out.println(human.desc);
    }

    @Test
    public void getSetField2() throws Exception {
        Class<Human> humanClass = Human.class;
        Human human = humanClass.newInstance();

        Field id = humanClass.getDeclaredField("id");
        id.setAccessible(true);
        id.set(human, 1111);
        System.out.println(human.toString());

    }

    @Test
    public void getSetMethod() throws Exception {
        Class<Human> humanClass = Human.class;
        Human human = humanClass.newInstance();

        Method show = humanClass.getDeclaredMethod("show", String.class, int.class);
        show.setAccessible(true);
        show.invoke(human, "林谦", 23);
    }

    @Test
    public void testGetConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Human> humanClass = Human.class;
        Constructor<Human> declaredConstructor = humanClass.getDeclaredConstructor(String.class);

        declaredConstructor.setAccessible(true);
        Human human = declaredConstructor.newInstance("linsz");
        System.out.println(human.toString());
        System.out.println(human.name);
    }
}
