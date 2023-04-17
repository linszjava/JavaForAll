package com.lin.ssm.dao;


import com.lin.ssm.pojo.Employees;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void listAllEmployees() {

        List<Employees> employees = employeeMapper.listAllEmployees();
        employees.forEach(System.out::println);
    }

    @Test
    public void listEmployeesWithDepart() {

        employeeMapper.listEmployeesWithDepart().forEach(System.out::println);

    }
}