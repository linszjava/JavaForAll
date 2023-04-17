package com.lin.senior.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: javase
 * @description: 反射测试 初体验
 * @author: linsz
 * @create: 2022-06-12 22:15
 **/
public class ReflectionDemo {
    @Test
    public void testUsualMethod() {
        Person person = new Person();
        person.setId(1).setName("linsz").setDesc("林谦");
        person.showInfo();
        System.out.println(person.toString());

    }

    @Test
    public void testMethodByReflection() throws Exception {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(int.class, String.class, String.class);
        constructor.setAccessible(true);
        Person person = constructor.newInstance(2, "linsz", "xiamenU");
        person.showInfo();
        System.out.println(person);

        System.out.println("====================");
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "林谦");
        System.out.println(person);
        //Method show = personClass.getDeclaredMethod("showInfo"); //this is a public method
        //personClass.getDeclaredMethod("show").invoke(person);
    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
class Person {

    private int id;
    private String name;
    private String desc;

    private void show() {
        System.out.println("this is a private method");
    }

    public void showInfo() {
        System.out.println("this is a public method");
    }
}
