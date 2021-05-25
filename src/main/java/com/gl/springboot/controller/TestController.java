/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.controller;

import com.gl.springboot.designpattern.observer.publisher.UserService;
import com.gl.springboot.jdk8.job.handler.GroupDataFileHandler;
import com.gl.springboot.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试Controller
 * @Auther: za-guanlei
 * @Date: 2021/05/25/10:48
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private GroupDataFileHandler groupDataFileHandler;

    @GetMapping("/user/register/{userName}")
    public ResultVO userRegister(@PathVariable String userName){
        return userService.register(userName);
    }

    @GetMapping("/readFile")
    public void readFile(){
        groupDataFileHandler.processor();
    }
}
