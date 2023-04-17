package com.lin.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: JavaForAll
 * @description: 过滤器 过滤未登录的操作
 * @author: linsz
 * @create: 2022-06-21 02:40
 **/
@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("filter init....");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter....");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String[] urls = {"/css/", "/imgs/", "/login.jsp", "/register.jsp", "/checkCodeServlet", "/loginServlet", "/registerServlet"};
        String s = request.getRequestURL().toString();
        for (String url : urls) {
            if (s.contains(url)) {
                filterChain.doFilter(request, servletResponse);
                return;
            }
        }
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user != null) {
            filterChain.doFilter(request, servletResponse);
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, servletResponse);
        }


    }

    @Override
    public void destroy() {


    }
}
