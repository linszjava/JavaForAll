package com.lin.senior.collection;

import org.junit.Test;

import java.util.*;

/**
 * @program: javase
 * @description: Collections 工具类的使用
 * @author: linsz
 * @create: 2022-06-09 04:12
 **/
public class CollectionsDemo {

    @Test
    public void testCollectionsAPI() {
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("id","2");
//        hashMap.put("name","linsz");
//        hashMap.put("age","23");
//        hashMap.put("birthday","1999-01-07");

        ArrayList<Integer> list = new ArrayList<>();
        list.add(22);
        list.add(11);
        list.add(41);
        list.add(16);
        list.add(44);

        //1. reverse()
        Collections.reverse(list);
        System.out.println(list);

        ArrayList arrayList = new ArrayList();
        arrayList.add(22);
        arrayList.add(11);

        //2. shuffle() 随机排列顺序
        Collections.shuffle(list);
        System.out.println(list);

        //3.sort() 排序
        Collections.sort(list);
        System.out.println(list);

        //4. swap()
        Collections.swap(list, 1, 2);
        System.out.println(list);

        //5. copy()
        List<Integer> dest = Arrays.asList(new Integer[list.size()]);
        Collections.copy(dest, list);
        System.out.println(dest);
    }
}
