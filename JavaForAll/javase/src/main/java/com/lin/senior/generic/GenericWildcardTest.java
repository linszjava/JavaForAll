package com.lin.senior.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javase
 * @description: 泛型通配符的使用
 * @author: linsz
 * @create: 2022-06-10 14:34
 **/
public class GenericWildcardTest {

    @Test
    public void testGenericWildcard() {
        List<?> listWithWildcard = new ArrayList<>();
        ArrayList<Object> list = new ArrayList<>();
        ArrayList<Integer> listWithInteger = new ArrayList<>();

        //加通配符的泛型 可读不可写
        Object o = listWithWildcard.get(0);
        //listWithWildcard.add();

        List<? extends Person> list1 = null;  //上限是Person
        List<? super Person> list2 = null;  // 下限是Person

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

        //  list1 = list2;  不可行
        list1 = list3;  // Student 转 Person 可行
        list1 = list4;  // Person 转 Person 可行
        //list1 = list5;  //不可行

        //list2 = list3;  // Student
        list2 = list4;
        list2 = list5;


    }
}

class Person {


}

class Student extends Person {

}

