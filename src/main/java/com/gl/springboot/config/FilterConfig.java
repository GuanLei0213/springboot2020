package com.gl.springboot.config;

import com.gl.springboot.filter.TransferTask2Filter;
import com.gl.springboot.filter.TransferTask3Filter;
import com.gl.springboot.filter.TransferTaskFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义配置过滤器，解决@WebFilter和@Order的方式配置顺序失效的问题
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean transferTaskFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        TransferTaskFilter transferTaskFilter = new TransferTaskFilter();

        filterRegistrationBean.setFilter(transferTaskFilter);
        filterRegistrationBean.addUrlPatterns("/transferTask/api/v1");//配置过滤规则,可以传一个List
        filterRegistrationBean.addInitParameter("name","hx");//设置init参数，可以传一个Map
        filterRegistrationBean.setName("transferTaskFilter");//设置过滤器名称
        filterRegistrationBean.setOrder(3);//执行次序，越小的先执行

        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean transferTask2Filter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        TransferTask2Filter transferTask2Filter = new TransferTask2Filter();

        filterRegistrationBean.setFilter(transferTask2Filter);
        filterRegistrationBean.addUrlPatterns("/transferTask/api/v1");
        filterRegistrationBean.addInitParameter("name","hx");
        filterRegistrationBean.setName("transferTask2Filter");
        filterRegistrationBean.setOrder(2);

        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean transferTask3Filter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        TransferTask3Filter transferTask3Filter = new TransferTask3Filter();

        filterRegistrationBean.setFilter(transferTask3Filter);
        filterRegistrationBean.addUrlPatterns("/transferTask/api/v1");
        filterRegistrationBean.addInitParameter("name","hx");
        filterRegistrationBean.setName("transferTask3Filter");
        filterRegistrationBean.setOrder(1);

        return filterRegistrationBean;
    }
}
