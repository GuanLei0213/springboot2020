/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.aop.aspect;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description: 定义日志切面
 *               可看到 切面由 切点 和 通知 组成。
 * @Auther: za-guanlei
 * @Date: 2021/05/28/16:26
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * 定义切点，并通过表达式指定要切入的位置
     * execution用来匹配连接点
     */
    @Pointcut("execution(* com.gl.springboot.aop.service.impl.UserServiceImpl.*(..))")
    public void pointcut(){
        log.info("执行了切点........");
    }

    /************************ 以下为定义通知（增强）Advice **********************/

    @Before(value = "pointcut()")
    public void beforeAdvice(JoinPoint joinPoint){
        log.info("执行了前置通知..............");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        // 记录下请求内容
        log.info("################URL : " + request.getRequestURL().toString());
        log.info("################HTTP_METHOD : " + request.getMethod());
        log.info("################IP : " + request.getRemoteAddr());
        log.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));

        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
        log.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("################TARGET: " + joinPoint.getTarget());//返回的是需要加强的目标类的对象
        log.info("################THIS: " + joinPoint.getThis());//返回的是经过加强后的代理类的对象
    }

    @After(value = "pointcut()")
    public void afterAdvice(){
        log.info("执行了后置通知..............");
    }

    /**
     * 这里注意  ProceedingJoinPoint  这个知识点
     */
    @Around(value = "pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        log.info("环绕通知执行前..............");
        Object result = pjp.proceed();
        log.info("环绕通知执行后，结果为：{}", JSONUtil.toJsonStr(result));
        return result;
    }

    //等等............
}
