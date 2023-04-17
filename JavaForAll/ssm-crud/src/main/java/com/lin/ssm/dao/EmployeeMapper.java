package com.lin.ssm.dao;

import com.lin.ssm.pojo.Employees;

import java.util.List;

/**
 * @program: ssm-crud
 * @description: 员工接口
 * @author: linsz
 * @create: 2022-06-29 17:59
 **/
public interface EmployeeMapper {

    List<Employees> listAllEmployees();

    List<Employees> listEmployeesWithDepart();
}
