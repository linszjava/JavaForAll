package com.lin.senior.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @program: javase
 * @description: Collection接口的方法
 * @author: linsz
 * @create: 2022-06-08 07:58
 **/
public class CollectionApiDemo {

    @Test
    public void testCollectionAPI() {
        Collection collection = new ArrayList();

        //1. add()
        collection.add(234);
        collection.add("234");
        collection.add("二三四");

        //2.size();
        System.out.println(collection.size());

        //3.clear();
        //collection.clear();

        //4.isEmpty()
        System.out.println(collection.isEmpty());

        //5. remove()
        //System.out.println(collection.remove(234));

        //6.toArray()
        Object[] objects = collection.toArray();
        for (Object o : collection) {
            System.out.println(o);
        }

        //7.hashCode()
        System.out.println(collection.hashCode());

        //8. contain()
        System.out.println(collection.contains("234"));

        //9.addAll()
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("123");
        System.out.println(collection.addAll(list));

        //10. containAll()
        System.out.println(collection.containsAll(list));
        System.out.println(collection);

        //11. toString()
        System.out.println(collection.toString());

        //12. retainAll()
        System.out.println(collection.retainAll(list));  //交集
        System.out.println(collection);

        //13. removeAll()  取差集
        System.out.println(collection.removeAll(list));
        System.out.println(collection);

        //14. equals()
        collection.addAll(list);
        System.out.println(collection.equals(list));

        //15. iterator() 放在iteratorDemo中
    }
}
