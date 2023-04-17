package com.lin.servlet.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/testResq")
public class HttpServletRequestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getContextPath();
        StringBuffer requestURL = request.getRequestURL();    //  http://localhost:8080/testResq
        String requestURI = request.getRequestURI();    //   /testResq
        String method = request.getMethod();   // GET
        String queryString = request.getQueryString();  //username=linsz&password=123
        System.out.println(contextPath);
        System.out.println(requestURL);
        System.out.println(requestURI);
        System.out.println(method);
        System.out.println(queryString);

        System.out.println(request.getHeader("user-agent"));
        System.out.println(request.getProtocol());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
