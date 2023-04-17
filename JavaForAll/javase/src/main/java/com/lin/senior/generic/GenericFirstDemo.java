package com.lin.senior.generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: javase
 * @description: 泛型初识
 * @author: linsz
 * @create: 2022-06-09 05:09
 **/
public class GenericFirstDemo {

    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("k1", 10);
        hashMap.put("k2", 9);
        hashMap.put("k3", 23);
        hashMap.put("k4", 55);

        Iterator<Map.Entry<String, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + "===>" + next.getValue());
        }
    }
}
