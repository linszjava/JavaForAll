package com.lin.senior.annotation;

import java.lang.annotation.Annotation;

/**
 * @program: javase
 * @description: 注解的使用以及自定义注解
 * @author: linsz
 * @create: 2022-06-08 05:39
 **/
public class MyAnnotationDemo {
    public static void main(String[] args) {
        Annotation[] annotations = Student.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

}

@MyAnnotation("lin")
class Person {

}

class Student extends Person {

}


