package com.example.springbootdemo.commom;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * TODO
 *
 * @author czq
 * @date 2021/7/12 11:28
 */
public class ThreadModel {

    public static void main(String[] args) {
        for(int i = 0; i < 300; i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            Thread.sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            });
            t.start();
        }
    }

}
