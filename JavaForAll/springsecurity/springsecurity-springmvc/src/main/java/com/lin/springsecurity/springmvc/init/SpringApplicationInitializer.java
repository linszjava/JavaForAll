package com.lin.springsecurity.springmvc.init;

import com.lin.springsecurity.springmvc.config.ApplicationConfig;
import com.lin.springsecurity.springmvc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @program: springsecurity
 * @description:  相当于web.xml 初始化 spring容器启动加载WebApplicationInitializer接口的所有实现类
 * @author: linsz
 * @create: 2022-10-20 17:51
 **/
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
