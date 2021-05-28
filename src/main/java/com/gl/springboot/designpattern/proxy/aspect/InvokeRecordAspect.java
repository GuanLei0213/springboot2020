/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.designpattern.proxy.aspect;

import com.gl.springboot.designpattern.proxy.handler.InvokeRecordHandler;
import com.gl.springboot.designpattern.proxy.handler.MethodAdviceHandler;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description: @Aspect 用来告诉 Spring 这是一个切面，然后 Spring 在启动会时扫描 @Pointcut 匹配的方法，
 *               然后对这些目标方法进行织入处理：即使用切面中打上 @Around 的方法来对目标方法进行增强处理
 * @Auther: za-guanlei
 * @Date: 2021/05/26/15:05
 */
@Component
@Aspect
@Order(1)
public class InvokeRecordAspect extends BaseMethodAspect{

    @Override
    @Pointcut("@annotation(com.gl.springboot.designpattern.proxy.anno.InvokeRecordAnno)")
    protected void pointcut() {

    }

    @Override
    protected Class<? extends MethodAdviceHandler<?>> getAdviceHandlerType() {
        return InvokeRecordHandler.class;
    }
}
