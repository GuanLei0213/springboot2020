/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.designpattern.observer.publisher;

import com.gl.springboot.designpattern.observer.UserRegisterEvent;
import com.gl.springboot.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户服务类
 * @Auther: za-guanlei
 * @Date: 2021/05/25/9:50
 */
@Service
@Slf4j
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * 提供用户注册方法，注册成功后要将注册的事件发布出去，这样观察者才能知道
     */
    public ResultVO register(String userName){
        //1.执行注册逻辑
        log.info("[{}]用户正在本系统执行注册逻辑......",userName);

        //2.注册完成后发布一下，以供观察者处理后面的逻辑
        log.info("[{}]用户在本系统执行注册逻辑成功......",userName);
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this,userName));
        return ResultVO.build(Boolean.TRUE,"注册成功!");
    }
}
