package com.lin.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @program: JavaForAll
 * @description: 监听器
 * @author: linsz
 * @create: 2022-06-21 02:50
 **/
@WebListener
public class ContextLoaderLister implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("contextInitialized...........");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextDestroyed...........");
    }
}
