package com.gl.springboot.config;

import com.gl.springboot.Interceptor.Login2Interceptor;
import com.gl.springboot.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //order值越大越先执行
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/transferTask/api/v1").order(2);
        registry.addInterceptor(new Login2Interceptor()).addPathPatterns("/transferTask/api/v1").order(1);
    }
}
