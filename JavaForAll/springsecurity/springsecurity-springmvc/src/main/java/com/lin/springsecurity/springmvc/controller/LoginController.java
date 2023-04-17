package com.lin.springsecurity.springmvc.controller;

import com.lin.springsecurity.springmvc.constant.SessionConstant;
import com.lin.springsecurity.springmvc.dto.UserDto;
import com.lin.springsecurity.springmvc.pojo.User;
import com.lin.springsecurity.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @program: springsecurity
 * @description: 登录控制器
 * @author: linsz
 * @create: 2022-10-24 21:48
 **/
@RestController
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login",produces = {"text/plain;charset=utf-8"})
    public String login(UserDto userDto, HttpSession session){
        User userDetails = authenticationService.authentication(userDto);
        session.setAttribute(SessionConstant.SESSION_USER_KEY,userDetails);
        return userDetails.getFullName()+"登录成功咯";
    }

    @GetMapping(value = "/logout",produces = "text/plain;charset=utf-8")
    public String logout(HttpSession session){
        session.invalidate();
        return "退出成功";
    }

    @GetMapping(value = "/r/r1",produces = "text/plain;charset=utf-8")
    public String getR1(HttpSession session){
        String fullName = null;
        Object sessionAttribute = session.getAttribute(SessionConstant.SESSION_USER_KEY);
        if (!Objects.isNull(sessionAttribute)){
             fullName = ((User) sessionAttribute).getFullName();
        }else {
            fullName = "匿名人士";
        }
        return fullName + "访问资源1";

    }
}
