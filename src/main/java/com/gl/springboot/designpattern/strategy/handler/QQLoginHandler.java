/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.designpattern.strategy.handler;

import com.gl.springboot.designpattern.strategy.LoginRequest;
import com.gl.springboot.designpattern.strategy.LoginResponse;
import com.gl.springboot.designpattern.strategy.LoginType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description: 策略1：QQ登录
 * @Auther: za-guanlei
 * @Date: 2021/05/25/15:00
 */
@Component
@Slf4j
public class QQLoginHandler implements LoginHandler{

    @Override
    public LoginType getLoginType() {
        return LoginType.QQ;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        log.info("用户[{}]通过[{}]登录本系统.........",loginRequest.getUserId(),loginRequest.getLoginType());
        return LoginResponse.success("通过QQ登录成功！",loginRequest.getUserId());
    }
}
