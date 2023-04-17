package com.lin.senior.collection;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: javase
 * @description: HashMap集合的使用
 * @author: linsz
 * @create: 2022-06-09 03:33
 **/
public class HashMapDemo {

    @Test
    public void testHashMap() {
        HashMap hashMap = new HashMap();
        //1. put()
        hashMap.put("sg", "三国");
        hashMap.put("sh", "水浒");
        hashMap.put("xy", "西游");
        hashMap.put("hl", "红楼");
        hashMap.put("hl", "红楼梦");

        //2. clear()
        // hashMap.clear();
        //3. size()
        System.out.println(hashMap.size());  //4

        //4. isEmpty()
        System.out.println(hashMap.isEmpty()); //false

        //5. containKey
        System.out.println(hashMap.containsKey("xh")); // false

        //6. containValue
        System.out.println(hashMap.containsValue("红楼")); // false

        //7. remove()
        System.out.println(hashMap.remove("hl")); //红楼梦

        //8. get()
        System.out.println(hashMap.get("xy")); // 西游

        //9. keySet()
        for (Object o : hashMap.keySet()) { //xy  sg  sh
            System.out.println(o);
        }

        //10. values()
        Collection values = hashMap.values();
        for (Object value : values) {
            System.out.println(value);
        }

        //11. entrySet()
        Set entrySet = hashMap.entrySet();
        for (Object entry : entrySet) {
            System.out.println(entry);
        }

        //12. hashMap.keySet().iterator();
        Iterator iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        //13.
        Iterator entrySetIterator = hashMap.entrySet().iterator();
        while (entrySetIterator.hasNext()) {
            Object next = entrySetIterator.next();
            System.out.println(next);
        }

        System.out.println(hashMap);
    }
}
