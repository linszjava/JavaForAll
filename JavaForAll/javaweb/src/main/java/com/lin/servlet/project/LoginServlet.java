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
import java.io.PrintWriter;

/**
 * @program: JavaForAll
 * @description: 登录的Servlet
 * @author: linsz
 * @create: 2022-06-19 20:41
 **/
@WebServlet("/loginServlet1")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserMapper mapper = SqlSessionUtil.getSqlSession(true).getMapper(UserMapper.class);
        User user = mapper.selectUser(username, password);
        System.out.println(user);
        PrintWriter writer = resp.getWriter();
        if (user == null) {
            writer.write("登录失败");
        } else {
            writer.write("登录成功");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
