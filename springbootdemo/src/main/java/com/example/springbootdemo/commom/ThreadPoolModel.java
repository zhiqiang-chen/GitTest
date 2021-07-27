package com.example.springbootdemo.commom;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author czq
 * @date 2021/7/15 15:50
 */
public class ThreadPoolModel {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,
                                                        3,
                                                        60,
                                                        TimeUnit.SECONDS,
                                                        new ArrayBlockingQueue<Runnable>(5),
                                                        Executors.defaultThreadFactory());

        try {
            for(int i=0;i<9;i++){
                pool.execute(new Task(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            pool.shutdown();
        }

    }
}
