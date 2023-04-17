package com.lin.mybatis.mapper;

import com.lin.mybatis.dto.EmployeesDTO;
import com.lin.mybatis.pojo.Departments;
import com.lin.mybatis.pojo.Employees;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: JavaForAll
 * @description: 部门接口
 * @author: linsz
 * @create: 2022-06-23 03:31
 **/
public interface DepartmentMapper {

    /**
     * 通过部门id 查看该部门下的所有员工 模拟一对多
     *
     * @param departmentId
     * @return
     */
    List<Departments> getDepartmentWithEmpsById(@Param("departmentId") Integer departmentId);

    /**
     * 按条件查询  测试trim choose 等动态sql
     *
     * @param employeesDTO
     * @return
     */
    List<Employees> selectAllByCondition(EmployeesDTO employeesDTO);
}
