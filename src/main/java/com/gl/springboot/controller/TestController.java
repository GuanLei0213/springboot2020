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
import com.gl.springboot.designpattern.proxy.anno.ExceptionHandleAnno;
import com.gl.springboot.designpattern.proxy.anno.InvokeRecordAnno;
import com.gl.springboot.designpattern.strategy.LoginRequest;
import com.gl.springboot.designpattern.strategy.LoginResponse;
import com.gl.springboot.designpattern.strategy.servoce.LoginService;
import com.gl.springboot.entity.UserInfo;
import com.gl.springboot.jdk8.job.handler.GroupDataFileHandler;
import com.gl.springboot.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private LoginService loginService;

    @Autowired
    private com.gl.springboot.aop.service.UserService userService2;

    @GetMapping("/user/register/{userName}")
    public ResultVO userRegister(@PathVariable String userName){
        return userService.register(userName);
    }

    @GetMapping("/readFile")
    public void readFile(){
        groupDataFileHandler.processor();
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return loginService.login(loginRequest);
    }

    @GetMapping("/proxy")
    @InvokeRecordAnno("测试代理模式")
    public Map<String, Object> testProxy(@RequestParam String biz,@RequestParam String param) {
        Map<String, Object> result = new HashMap<>(4);
        result.put("id", 123);
        result.put("nick", "之叶");
        return result;
    }

    @GetMapping("/proxy2")
    @ExceptionHandleAnno
    @InvokeRecordAnno("测试代理模式")
    public Map<String, Object> testProxy2(@RequestParam String biz, @RequestParam String param) {
        if (biz.equals("abc")) {
            throw new IllegalArgumentException("非法的 biz=" + biz);
        }
        Map<String, Object> result = new HashMap<>(4);
        result.put("id", 123);
        result.put("nick", "之叶");
        return result;
    }

    @PostMapping("/add/userInfo")
    public ResultVO addUserInfo(@RequestBody UserInfo userInfo){
        return userService2.addUserInfo(userInfo);
    }

}
