package com.example.springbootdemo.service;


import com.example.springbootdemo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author czq
 * @date 2021/6/2 17:11
 */
@Slf4j
@Service
public class  RedisService{
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * description: 依据标识获取缓存值
     * date: 2021/6/3 15:52
     * author: czq
     * @param:
     * @return com.example.springbootdemo.entity.User
     */
    public boolean setUser(User user){
        ValueOperations ops=redisTemplate.opsForValue();
        ops.set(user.getNickname(),user);
        redisTemplate.expire(user.getNickname(), 10L,TimeUnit.MINUTES);
        log.info("{}",user.toString());
        return true;
    }
    /**
     * description: 添加缓存
     * date: 2021/6/3 15:52
     * author: czq
     * @param :
     * @return com.example.springbootdemo.entity.User
     */
    public User getUser(String name){
        ValueOperations ops=redisTemplate.opsForValue();
        log.info("opt:{}",ops.get("quellan"));
        User user = (User) ops.get(name);
        return user;
    }

    /**
     * description: 依据指定id从缓存获取数据，若缓存为空，则从数据库取值，并插入缓存
     * date: 2021/6/3 15:56
     * author: czq
     * @param: id
     * @return java.lang.String
     */
    public String test() {
        String test = "shuju";
        return test;
    }
}