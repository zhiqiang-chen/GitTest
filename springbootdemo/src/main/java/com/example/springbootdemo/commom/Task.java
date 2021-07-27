package com.example.springbootdemo.commom;

/**
 * TODO
 *
 * @author czq
 * @date 2021/7/15 17:11
 */
public class Task implements Runnable{
    private int nov;
    public Task(int i){
        this.nov=i;
    }

    @Override
    public void run() {
        System.out.println("执行当前任务的线程是："+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("任务"+nov+"执行完毕");
    }
}
