package com.lin.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @program: JavaForAll
 * @description: 查询dto
 * @author: linsz
 * @create: 2022-06-23 08:58
 **/
@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesDTO {

    private Integer employeeName;

    private String lastName;

    private String managerName;

    private String departmentName;


}
