package com.lin.senior.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @program: javase
 * @description: iterator 迭代器的使用
 * @author: linsz
 * @create: 2022-06-08 08:42
 **/
public class IteratorDemo {

    @Test
    public void testIterator() {
        Collection collection = new ArrayList();

        collection.add(123);
        collection.add(123);
        collection.add(123);
        collection.add(234);
        collection.add("234");
        collection.add("二三四");

//          Iterator iterator = collection.iterator();
//        while (iterator.hasNext()){
//            Object next = iterator.next();
//            System.out.println(next);
//            if (next.equals("234")){
//                iterator.remove();
//            }
//        }
//        System.out.println("***************");
//
//       Iterator iterator = collection.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        /**
         * -------------------
         * 123:class java.lang.Number
         * 123:class java.lang.Number
         * 123:class java.lang.Number
         * 234:class java.lang.Number
         * 234:class java.lang.Object
         * 二三四:class java.lang.Object
         *
         * 注意：输出结果如上所示，但是你要注意，虽然输入的是234 和 "234" 输出的都是 234， 但是二者的类型还是不一样，这点需要注意
         */
        System.out.println("-------------------");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next + ":" + next.getClass().getSuperclass());
        }
    }
}
