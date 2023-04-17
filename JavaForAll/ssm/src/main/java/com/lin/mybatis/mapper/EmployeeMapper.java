package com.lin.mybatis.mapper;

import com.lin.mybatis.pojo.Employees;

import java.util.List;

/**
 * @program: JavaForAll
 * @description: Employee员工接口
 * @author: linsz
 * @create: 2022-06-23 03:30
 **/
public interface EmployeeMapper {

    /**
     * 查看所有的员工及其所在的部门 多对一操作
     *
     * @return
     */
    List<Employees> selectAllEmployeesWithDepartment();


}
