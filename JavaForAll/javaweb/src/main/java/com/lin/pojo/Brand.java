package com.lin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @program: JavaForAll
 * @description: 品牌实体类 专为mybatis测试使用
 * @author: linsz
 * @create: 2022-06-18 19:30
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
