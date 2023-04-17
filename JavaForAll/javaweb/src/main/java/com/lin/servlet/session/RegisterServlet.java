package com.lin.servlet.session;

import com.lin.pojo.User;
import com.lin.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: JavaForAll
 * @description: 注册Servlet
 * @author: linsz
 * @create: 2022-06-21 00:37
 **/
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
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
        String checkCode = req.getParameter("checkCode");
        User user = userService.selectByUserByUsername(username);
        HttpSession session = req.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");
        if (!checkCodeGen.equalsIgnoreCase(checkCode)) {
            session.setAttribute("register_errMsg", "验证码不正确");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        if (user == null) {
            userService.addUser(new User(null, username, password));
//            HttpSession session = req.getSession();
            session.setAttribute("register_sucMsg", "注册成功");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            //HttpSession session = req.getSession();
            session.setAttribute("register_errMsg", "注册失败，用户名已存在");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }

    }
}
