package com.gl.springboot.config;

import com.gl.springboot.listener.WebListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfig {

    @Bean
    public ServletListenerRegistrationBean webListener(){
        ServletListenerRegistrationBean registration = new ServletListenerRegistrationBean<>();
        WebListener webListener = new WebListener();
        registration.setListener(webListener);
        // 设置排序，存在多个Listener实例的情况下确定Listener的执行顺序
        registration.setOrder(1);
        return registration;
    }
}
