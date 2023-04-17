package com.lin.senior.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: javase
 * @description: 测试对象流
 * @author: linsz
 * @create: 2022-06-12 06:24
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 4326363422L;

    private int id;
    private String name;
    private String desc;
}
