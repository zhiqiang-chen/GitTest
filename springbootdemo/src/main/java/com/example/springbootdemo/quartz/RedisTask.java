package com.example.springbootdemo.quartz;

import com.example.springbootdemo.service.RedisService;
import com.example.springbootdemo.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

/**
 * TODO 缓存定时器
 *
 * @author czq
 * @date 2021/6/3 16:18
 */
@Slf4j
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class RedisTask {
    @Autowired
    private RedisService redisService;
    @Autowired
    private RedisUtils redisUtils;

    @Scheduled(cron = "50 * * ? * *")
    public void redisTest(){
        log.info("缓存定时器开始执行");
        String id = "111";
        Boolean flag = updateRedis(id);
        if(!flag){
            log.info("缓存定时器执行异常");
        }
        log.info("缓存定时器结束执行");
    }

    public Boolean updateRedis(String id) {
        //从数据库中获取信息
        log.info("从数据库中获取数据");
        String str = redisService.test();
        //删除缓存
        log.info("从缓存删除数据");
        redisUtils.remove(id);
        //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
        Boolean flag = redisUtils.set(id,str);
        log.info("数据插入缓存" + str);
        return flag;
    }

}
