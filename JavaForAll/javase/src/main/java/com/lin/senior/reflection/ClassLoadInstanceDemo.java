package com.lin.senior.reflection;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

/**
 * @program: javase
 * @description: 获取类Class实例的四种方式
 * @author: linsz
 * @create: 2022-06-12 23:12
 **/
public class ClassLoadInstanceDemo {

    @Test
    public void test() throws ClassNotFoundException {
        //1. 实例对象.getClass()
        Person person = new Person();
        Class<? extends Person> clazz1 = person.getClass();

        //2. 类.class
        Class<Person> clazz2 = Person.class;

        //3. Class.forName()
        Class<?> clazz3 = Class.forName("com.lin.senior.reflection.Person");

        //4. 类加载器
        Class<?> clazz4 = ClassLoadInstanceDemo.class.getClassLoader().loadClass("com.lin.senior.reflection.Person");

        System.out.println(clazz1 == clazz2 && clazz1 == clazz3 && clazz1 == clazz4);

    }

    @Test
    public void testClassStruct() {
        Class<Integer> integerClass = int.class;
        Class<String> stringClass = String.class;
        Class<int[]> aClass = int[].class;
        Class<int[][]> aClass1 = int[][].class;
        Class<Override> overrideClass = Override.class;
        Class<Person> personClass = Person.class;
        Class<ClassLoadInstanceDemo> classLoadInstanceDemoClass = ClassLoadInstanceDemo.class;
        Class<Class> classClass = Class.class;
        Class<Void> voidClass = void.class;
        Class<Method> methodClass = Method.class;
        Class<Comparable> comparableClass = Comparable.class;
        Class<Object> objectClass = Object.class;
        Class<ElementType> elementTypeClass = ElementType.class;
    }
}
