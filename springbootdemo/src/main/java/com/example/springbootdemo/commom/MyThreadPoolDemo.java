package com.example.springbootdemo.commom;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author czq
 * @date 2021/7/15 11:35
 */
public class MyThreadPoolDemo {
    @ResponseBody
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);//一池5个处理线程
//        ExecutorService pool = Executors.newSingleThreadExecutor();//一池一个线程
//        ExecutorService pool = Executors.newCachedThreadPool();//一池N个线程
        try {
            for (int i = 0;i < 10;i++){
                pool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t deal");
                });
                TimeUnit.MICROSECONDS.sleep(2000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
