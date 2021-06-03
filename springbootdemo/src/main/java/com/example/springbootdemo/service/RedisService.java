package com.example.springbootdemo.service;


import com.example.springbootdemo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

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
    public boolean setUser(User user){
        ValueOperations ops=redisTemplate.opsForValue();
        ops.set(user.getNickname(),user);
        log.info("{}",user.toString());
        return true;
    }
    public User getUser(String name){
        ValueOperations ops=redisTemplate.opsForValue();
        log.info("opt:{}",ops.get("quellan"));
        User user = (User) ops.get(name);
        return user;
    }

}