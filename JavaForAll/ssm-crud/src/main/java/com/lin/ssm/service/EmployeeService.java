package com.lin.ssm.service;

import com.lin.ssm.dao.EmployeeMapper;
import com.lin.ssm.pojo.Employees;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ssm-crud
 * @description: 员工业务类
 * @author: linsz
 * @create: 2022-06-29 21:56
 **/
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employees> getAllEmployees() {
        return employeeMapper.listEmployeesWithDepart();
    }
}
