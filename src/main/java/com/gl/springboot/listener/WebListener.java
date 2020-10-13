package com.gl.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("初始化监听器.........");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("销毁监听器.........");
    }
}
