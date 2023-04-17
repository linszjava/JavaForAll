package com.lin.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @program: JavaForAll
 * @description: 名牌实体类
 * @author: linsz
 * @create: 2022-06-17 19:36
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Brand {

    private Integer id;

    private String brandName;

    private String companyName;

    private Integer ordered;

    private String description;

    private Integer status;
}
