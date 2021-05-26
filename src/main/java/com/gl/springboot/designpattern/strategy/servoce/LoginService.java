/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.designpattern.strategy.servoce;

import com.gl.springboot.designpattern.strategy.LoginHandlerFactory;
import com.gl.springboot.designpattern.strategy.LoginRequest;
import com.gl.springboot.designpattern.strategy.LoginResponse;
import com.gl.springboot.designpattern.strategy.handler.LoginHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Auther: za-guanlei
 * @Date: 2021/05/25/16:22
 */
@Service
public class LoginService {

    @Autowired
    private LoginHandlerFactory loginHandlerFactory;

    public LoginResponse login(LoginRequest loginRequest){
        LoginHandler handler = loginHandlerFactory.getHandler(loginRequest.getLoginType());
        return handler.login(loginRequest);
    }
}
