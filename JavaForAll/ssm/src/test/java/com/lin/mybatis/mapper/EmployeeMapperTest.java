package com.lin.mybatis.mapper;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.mybatis.pojo.Employees;
import com.lin.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class EmployeeMapperTest {


    @Test
    public void selectAllEmployeesWithDepartment() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession(true);
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        PageHelper.startPage(1, 10);
        PageInfo<Employees> info = new PageInfo<>();
//        PageInfo{pageNum=0, pageSize=0, size=0, startRow=0, endRow=0, total=0, pages=0,
//        list=null, prePage=0, nextPage=0, isFirstPage=false, isLastPage=false,
//        hasPreviousPage=false, hasNextPage=false, navigatePages=0, navigateFirstPage=0,
//        navigateLastPage=0, navigatepageNums=null}
        System.out.println("*****" + info);
        employeeMapper.selectAllEmployeesWithDepartment().forEach(System.out::println);
        System.out.println("----------");
        //employeeMapper.selectAllEmployeesWithDepartment().forEach(System.out::println);


    }


}