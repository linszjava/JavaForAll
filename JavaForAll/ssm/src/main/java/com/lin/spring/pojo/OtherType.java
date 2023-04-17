package com.lin.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @program: JavaForAll
 * @description: 其他类型的属性注入  如数组 集合List Set Map
 * @author: linsz
 * @create: 2022-06-24 04:22
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OtherType {

    private String[] arrayString;

    private List<String> stringList;

    private Set<String> stringSet;

    private HashMap<String, String> hashMap;
}
