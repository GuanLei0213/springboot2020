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
 * @Description: 策略2：微信登录
 * @Auther: za-guanlei
 * @Date: 2021/05/25/14:39
 */
@Component
@Slf4j
public class WeChatLoginHandler implements LoginHandler<String> {

    @Override
    public LoginType getLoginType() {
        return LoginType.WE_CHAT;
    }

    @Override
    public LoginResponse<String> login(LoginRequest loginRequest) {
        log.info("用户[{}]通过[{}]登录本系统.........",loginRequest.getUserId(),loginRequest.getLoginType());
        return LoginResponse.success("通过微信登录成功！",loginRequest.getUserId());
    }
}
