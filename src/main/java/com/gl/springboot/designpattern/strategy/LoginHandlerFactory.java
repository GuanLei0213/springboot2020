/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.designpattern.strategy;

import com.gl.springboot.designpattern.strategy.handler.LoginHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 通过该登录工厂找到具体的登录策略
 * @Auther: za-guanlei
 * @Date: 2021/05/25/15:17
 */
@Component
@Slf4j
public class LoginHandlerFactory implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * 存放具体策略的容器
     */
    private static final Map<LoginType,LoginHandler> LOGIN_HANDLER_MAP = new ConcurrentHashMap<>();

    /**
     * 初始化时将登录处理器放入到Map容器中
     */
    @Override
    public void afterPropertiesSet(){
        Map<String, LoginHandler> beansOfType = applicationContext.getBeansOfType(LoginHandler.class);
        // 将 Spring 容器中所有的 LoginHandler 注册到 LOGIN_HANDLER_MAP中
        for (String key : beansOfType.keySet()) { //遍历Map中的所有key
            LoginHandler loginHandler = beansOfType.get(key);
            LOGIN_HANDLER_MAP.put(loginHandler.getLoginType(),loginHandler);
        }
        log.info("登录策略的盛放容器初始化完成,总大小：{}..........",LOGIN_HANDLER_MAP.size());
    }

    /**
     * 根据登录类型获取对应的登录处理器
     * @param loginType
     * @return
     */
    public LoginHandler getHandler(LoginType loginType) {
        return LOGIN_HANDLER_MAP.get(loginType);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
