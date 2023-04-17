package com.lin.basic.oop;

/**
 * @program: Java
 * @description: 通过this调用构造器
 * 1.注意this的getter与setter方法的使用
 * 2.注意this()；调用构造器的使用，注意只能放在第一行，最多有n-1个this()被调用
 * 3.注意调用时避免形成回路，死循环
 * @author: linsz
 * @create: 2022-06-04 12:48
 **/
public class ThisUseConstructorDemo {
    public static void main(String[] args) {
        Person person = new Person();

        person.setId(18);
        System.out.println(person.getId());

    }

}

class Person {
    private int id;
    private String name;

    public Person() {
        System.out.println("无参构造器被调用了");
    }

    public Person(int id) {
        this();
        this.id = id;
        System.out.println("一个id的有参构造器");
    }

    public Person(int id, String name) {
        this(id);
        // this.id = id;
        this.name = name;
        System.out.println("全参的有参构造器");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
