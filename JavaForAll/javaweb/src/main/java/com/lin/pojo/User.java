package com.lin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @program: JavaForAll
 * @description: User 实体类
 * @author: linsz
 * @create: 2022-06-19 20:06
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {

    private Integer id;

    private String username;

    private String password;
}
