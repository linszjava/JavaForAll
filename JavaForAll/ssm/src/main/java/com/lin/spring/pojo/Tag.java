package com.lin.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @program: JavaForAll
 * @description: 标签
 * @author: linsz
 * @create: 2022-06-24 01:03
 **/
@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    private String tagName;
    private String desc;
}
