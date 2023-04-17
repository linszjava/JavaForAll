package com.lin.servlet.project;

import com.lin.mapper.UserMapper;
import com.lin.pojo.User;
import com.lin.utils.SqlSessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: JavaForAll
 * @description: 注册Servlet
 * @author: linsz
 * @create: 2022-06-19 21:00
 **/
@WebServlet("/registerServlet1")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserMapper mapper = SqlSessionUtil.getSqlSession(true).getMapper(UserMapper.class);
        User user = mapper.selectUserByUsername(username);
        if (user != null) {
            resp.getWriter().write("该用户已存在，请重新注册");
        } else {
            mapper.add(new User(null, username, password));
            resp.getWriter().write("注册成功");
        }
    }
}
