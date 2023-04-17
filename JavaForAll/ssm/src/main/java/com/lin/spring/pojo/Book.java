package com.lin.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @program: JavaForAll
 * @description: Book 实体类
 * @author: linsz
 * @create: 2022-06-24 00:38
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Book {

    private String bookName;

    private String bookAuthor;

    private Tag tag;

}
