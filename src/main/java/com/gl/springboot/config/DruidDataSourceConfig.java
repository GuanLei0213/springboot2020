package com.gl.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidDataSourceConfig {

    /**
     * 声明要注入的属性前缀，Springboot会自动从配置文件中读取属性的值并自动映射到对象的属性上，无需手动set
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDateSource(){
        return new DruidDataSource();
    }

    //配置一个druid的监控
    //1.配置一个后台的Servlet
    /*@Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        HashMap<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","admin");
        initParams.put("allow",""); //默认是允许所有访问
        initParams.put("deny","192.168.15.21"); //拒绝该地址访问
        bean.setInitParameters(initParams);
        return bean;
    }

    //2.配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        HashMap<String, String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");//不拦截
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));//拦截所有请求
        return  bean;
    }*/
}
