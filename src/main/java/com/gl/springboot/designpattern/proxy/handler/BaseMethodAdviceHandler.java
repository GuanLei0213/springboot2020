/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.designpattern.proxy.handler;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * @Description: 为了方便 MethodAdviceHandler 的使用，定义一个抽象类，提供一些常用的方法。
 * @Auther: za-guanlei
 * @Date: 2021/05/26/11:04
 */
@Slf4j
public abstract class BaseMethodAdviceHandler<R> implements MethodAdviceHandler<R>{

    /**
     * 抛出异常时候的默认处理
     */
    @Override
    public void onThrow(ProceedingJoinPoint point, Throwable e) {
        String methodDesc = getMethodDesc(point);
        Object[] args = point.getArgs();
        log.error("{} 执行时出错，入参={}", methodDesc, JSONUtil.toJsonStr(args), e);
    }

    /**
     * 获得方法描述，目标类名.方法名
     *
     * @param point 连接点
     * @return 目标类名.执行方法名
     */
    protected String getMethodDesc(ProceedingJoinPoint point) {
        // 获得被代理的类
        Object target = point.getTarget();
        String className = target.getClass().getSimpleName();

        Signature signature = point.getSignature();
        String methodName = signature.getName();

        return className + "." + methodName;
    }


    /**
     * 获得被代理的方法
     *
     * @param point 连接点
     * @return 代理的方法
     */
    protected Method getTargetMethod(ProceedingJoinPoint point) {
        // 获得方法签名
        Signature signature = point.getSignature();
        // Spring AOP 只有方法连接点，所以 Signature 一定是 MethodSignature
        return ((MethodSignature) signature).getMethod();
    }

}
