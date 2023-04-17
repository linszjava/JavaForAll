package com.lin.servlet.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp1")
public class ResponseServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //response.setContentType("text/html;charset=utf-8");
        //1.重定向
        //response.sendRedirect("/resp2");
        //2. 字节 字符的写出  common-io
//        PrintWriter writer = response.getWriter();
//        writer.write("<h2>你好啊</h2>");
        FileInputStream fis = new FileInputStream("/Users/linsz/Downloads/img/landscape-2.jpeg");
        ServletOutputStream os = response.getOutputStream();
        IOUtils.copy(fis, os);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
