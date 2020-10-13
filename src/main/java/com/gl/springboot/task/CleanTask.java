package com.gl.springboot.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CleanTask {

    @Scheduled(fixedDelayString = "${cleanTask.fixedDelay}")
    public void execute(){
//        System.out.println(Thread.currentThread().getName()+"间隔1s执行");
    }

    @Scheduled(cron = "${cleanTask.cron}")
    public void execute1(){
//        System.out.println(Thread.currentThread().getName()+"间隔2s执行.。。。。。。");
    }
}
