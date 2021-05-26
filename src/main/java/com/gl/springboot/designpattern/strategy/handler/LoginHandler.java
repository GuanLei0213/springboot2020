package com.gl.springboot.designpattern.strategy.handler;

import com.gl.springboot.designpattern.strategy.LoginRequest;
import com.gl.springboot.designpattern.strategy.LoginResponse;
import com.gl.springboot.designpattern.strategy.LoginType;

import java.io.Serializable;

/**
 * @Description: 父类接口或抽象类，具体策略需要实现该接口
 * @Auther: za-guanlei
 * @Date: 2021/05/25/14:33
 */
public interface LoginHandler<T extends Serializable> {

    /**
     * 获取登录类型
     */
    LoginType getLoginType();

    /**
     * 登录逻辑
     */
    LoginResponse<T> login(LoginRequest loginRequest);
}

