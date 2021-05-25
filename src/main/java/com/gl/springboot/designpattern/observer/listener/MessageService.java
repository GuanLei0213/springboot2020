/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.designpattern.observer.listener;

import com.gl.springboot.designpattern.observer.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @Description: 短信服务类，监听用户注册服务，注册成功后发送短信
 * @Auther: za-guanlei
 * @Date: 2021/05/25/10:25
 */
@Service
@Slf4j
public class MessageService {

    @EventListener
    public void sendMessage(UserRegisterEvent userRegisterEvent){
        log.info("[{}]用户在本系统注册成功，执行发送短信逻辑......",userRegisterEvent.getUserName());
    }
}
