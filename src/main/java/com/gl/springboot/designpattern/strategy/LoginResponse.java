/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.designpattern.strategy;

import lombok.Data;

/**
 * @Description: 登录响应
 * @Auther: za-guanlei
 * @Date: 2021/05/25/14:32
 */
@Data
public class LoginResponse<T> {

    private String str;

    private T t;

    public LoginResponse(String str, T t) {
        this.str = str;
        this.t = t;
    }

    public static LoginResponse success(String string, Object obj){
        return new LoginResponse<>(string,obj);
    }
}
