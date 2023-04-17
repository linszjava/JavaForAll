package com.lin.mybatis.mapper;

import com.github.pagehelper.PageHelper;
import com.lin.mybatis.dto.EmployeesDTO;
import com.lin.mybatis.pojo.Employees;
import com.lin.mybatis.utils.SqlSessionUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DepartmentMapperTest {

    @Test
    public void getDepartmentWithEmpsById() {
        DepartmentMapper mapper = SqlSessionUtils.getSqlSession(true).getMapper(DepartmentMapper.class);
        mapper.getDepartmentWithEmpsById(60).forEach(System.out::println);
    }

    @Test
    public void testIf() {
        DepartmentMapper mapper = SqlSessionUtils.getSqlSession(true).getMapper(DepartmentMapper.class);
        List<Employees> employees = mapper.selectAllByCondition(new EmployeesDTO(null, null, "Raphaely", "IT"));
        employees.forEach(System.out::println);
    }
}