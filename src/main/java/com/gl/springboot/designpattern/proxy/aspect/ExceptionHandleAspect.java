/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.designpattern.proxy.aspect;

import com.gl.springboot.designpattern.proxy.handler.ExceptionHandleHandler;
import com.gl.springboot.designpattern.proxy.handler.MethodAdviceHandler;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description: 异常处理的切面
 * @Auther: za-guanlei
 * @Date: 2021/05/26/16:40
 */
@Component
@Aspect
@Order(10)
public class ExceptionHandleAspect extends BaseMethodAspect{

    @Override
    @Pointcut("@annotation(com.gl.springboot.designpattern.proxy.anno.ExceptionHandleAnno)")
    protected void pointcut() {

    }

    @Override
    protected Class<? extends MethodAdviceHandler<?>> getAdviceHandlerType() {
        return ExceptionHandleHandler.class;
    }
}
