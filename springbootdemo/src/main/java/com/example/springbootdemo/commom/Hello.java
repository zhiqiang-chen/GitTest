package com.example.springbootdemo.commom;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author czq
 * @date 2021/7/16 11:24
 */
@Component
public class Hello {
    @Async("taskExecutor")
    public void tesTask(int i){
        System.out.println(Thread.currentThread().getName()+"-----"+i);
    }

    @Async("taskExecutor")
    public void stringTask(String str){

        System.out.println(Thread.currentThread().getName()+"-----"+str);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
