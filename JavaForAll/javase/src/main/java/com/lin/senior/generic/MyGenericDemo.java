package com.lin.senior.generic;

import lombok.experimental.Accessors;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javase
 * @description: 自定义泛性类 和泛型方法
 * @author: linsz
 * @create: 2022-06-09 15:07
 **/
public class MyGenericDemo {

    @Test
    public void testGenericClass() {
        //Order.copyList(); 泛型方法可以声明为静态
        Order<String> stringOrder = new Order<>();

        stringOrder.setId(12);
        stringOrder.setName("APPLE");
        stringOrder.setDesc("苹果");

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(11);
        integers.add(12);
        integers.add(13);
        integers.add(14);
        System.out.println(stringOrder.copyList(integers));

        System.out.println(stringOrder.getDesc());
    }

}

class Order<T> {

    private int id;
    private String name;

    private T desc;

    public Order() {
    }

    public Order(int id, String name, T desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getDesc() {
        return desc;
    }

    public void setDesc(T desc) {
        this.desc = desc;
    }

    //自定义泛型方法
    public static <E> List<E> copyList(List<E> list) {
        ArrayList<E> arrayList = new ArrayList<>();
        for (E e : list) {
            arrayList.add(e);
        }
        return arrayList;
    }
}

class Customer {

}

class Consumer<T> extends Customer {

}

class AA extends Order {

}
