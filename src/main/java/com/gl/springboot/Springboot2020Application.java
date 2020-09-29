package com.gl.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(value = "com.gl.springboot.dao")//接口扫描，如果此处不加@MapperScan注解必须在接口类上添加@Mapper注解表明这是一个接口扫描器
@EnableTransactionManagement // 开启注解事务管理，等同于xml配置文件中的 <tx:annotation-driven />
@SpringBootApplication
public class Springboot2020Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2020Application.class, args);
    }

}
