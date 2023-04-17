package com.lin.servlet.session;

import com.lin.pojo.User;
import com.lin.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @program: JavaForAll
 * @description: 登录LoginServlet
 * @author: linsz
 * @create: 2022-06-20 17:45
 **/
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.selectUser(username, password);
        if (user == null) {
            req.setAttribute("login_errMsg", "用户名或者密码错误");
            //请求转发 地址栏不发生改变  共享数据
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            String remember = req.getParameter("remember");
            if ("1".equals(remember)) {
                Cookie c_username = new Cookie("username", username);
                Cookie c_passoword = new Cookie("password", password);
                req.setAttribute("c_username", c_username);
                req.setAttribute("c_passoword", c_passoword);

                c_username.setMaxAge(60 * 60 * 24 * 7);
                c_passoword.setMaxAge(60 * 60 * 24 * 7);
                resp.addCookie(c_username);
                resp.addCookie(c_passoword);
            }

            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("/loginSuccess.jsp");
        }

    }
}
