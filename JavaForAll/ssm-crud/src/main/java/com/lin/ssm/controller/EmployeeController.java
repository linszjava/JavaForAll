package com.lin.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.ssm.pojo.Employees;
import com.lin.ssm.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ssm-crud
 * @description: 员工应用层
 * @author: linsz
 * @create: 2022-06-29 21:58
 **/
@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/list")
    public String showAllEmployees(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
                                   Model model) {

        PageHelper.startPage(pageNum, pageSize);
        List<Employees> employeesList = employeeService.getAllEmployees();
        PageInfo<Employees> pageInfo = new PageInfo<>();
        model.addAttribute("page", pageInfo);

        return "list";


    }


}
