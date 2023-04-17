package com.lin.senior.collection;

import org.junit.Test;

import java.util.*;

/**
 * @program: javase
 * @description: ArrayList常用API
 * @author: linsz
 * @create: 2022-06-08 15:43
 **/
public class ArrayListAPIDemo {

    @Test
    public void testArrayListAPI() {
        List arrayList = new ArrayList();

        arrayList.add(13);
        arrayList.add(345);
        arrayList.add(234);
        arrayList.add(2);
        arrayList.add(123);

//        Object remove = arrayList.remove(1);
//        System.out.println(remove);

        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        List list = arrayList.subList(0, 2);
        System.out.println(list);

        System.out.println(arrayList.indexOf("123"));

        System.out.println(arrayList.lastIndexOf(123));

        arrayList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    return Integer.compare((Integer) o1, (Integer) o2);
                } else
                    throw new RuntimeException("输入不合法");
            }
        });
        System.out.println(arrayList);

    }
}
