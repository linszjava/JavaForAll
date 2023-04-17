package com.lin.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @program: JavaForAll
 * @description: 部门实体类
 * @author: linsz
 * @create: 2022-06-23 03:12
 **/
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Departments {

    private Integer departmentId;

    private String departmentName;

    private Integer managerId;

    private Integer locationId;

    /**
     * 一对多 集合
     */
    List<Employees> employeesList;


}
