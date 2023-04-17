package com.lin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @program: JavaForAll
 * @description: BrandDTO 模糊查询
 * @author: linsz
 * @create: 2022-06-18 20:35
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BrandDTO {

    private Integer status;

    private String brandName;

    private String companyName;
}
