package com.lin.servlet.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/demo1")
public class DoPostTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        System.out.println(username);

//        Map<String, String[]> map = request.getParameterMap();
//        for (Map.Entry<String, String[]> entry : map.entrySet()) {
//            String k = entry.getKey();
//            System.out.print(k+"\t");
//            for (String s : entry.getValue()) {
//                System.out.print(s+"\t");
//            }
//            System.out.println();
//        }
    }
}
