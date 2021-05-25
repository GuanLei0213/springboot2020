/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.designpattern.observer;

import org.springframework.context.ApplicationEvent;

/**
 * @Description: 自定义用户注册事件，发布者负责将该事件发布出去
 * @Auther: za-guanlei
 * @Date: 2021/05/24/17:35
 */
public class UserRegisterEvent extends ApplicationEvent {

    private String userName;

    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source, String userName) {
        super(source);
        this.userName = userName;
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    public String getUserName() {
        return userName;
    }
}
