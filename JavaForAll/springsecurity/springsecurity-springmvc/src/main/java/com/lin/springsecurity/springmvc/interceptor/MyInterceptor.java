package com.lin.springsecurity.springmvc.interceptor;

import com.lin.springsecurity.springmvc.constant.SessionConstant;
import com.lin.springsecurity.springmvc.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Set;

/**
 * @program: springsecurity
 * @description: 资源请求路径拦截器
 * @author: linsz
 * @create: 2022-10-26 23:35
 **/
@Component
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 在请求资源之前拦截测试
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 先从请求的中查询是否携带 session
        Object sessionUserKey = request.getSession().getAttribute(SessionConstant.SESSION_USER_KEY);
        //如果没有登录
        if (Objects.isNull(sessionUserKey)){
            writeContent(response,"请登录");
        }
        // 查询用户的权限
        Set<String> authorities = ((User) sessionUserKey).getAuthorities();
        // 查询用户的请求路径
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        if (authorities.contains("p1") && requestURI.contains("/r1")){
            return true;
        }
        if (authorities.contains("p2") && requestURI.contains("/r2")){
            return true;
        }
        //其他情况
        writeContent(response,"权限不足，拒绝访问");
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    /**
     * 根据响应请求结果做出回应 输出
     * @param response
     * @param msg
     */
    private void writeContent(HttpServletResponse response,String msg) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(msg);
        writer.close();
        response.resetBuffer();
    }
}
