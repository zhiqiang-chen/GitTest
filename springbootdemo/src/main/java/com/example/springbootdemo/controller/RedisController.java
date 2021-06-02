package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * TODO
 *
 * @author czq
 * @date 2021/6/2 17:17
 */
@RestController
public class RedisController {
    @Autowired
    private RedisService redisService;
    @RequestMapping("/getUser")
    public User getUser(){
        String name="quellan";
        return redisService.getUser(name);
    }
    @RequestMapping("/setUser")
    public String setUser(){
        User user=new User("aa@qq.com","quellan","123456","朱",System.currentTimeMillis()+"",1L);
        redisService.setUser(user);
        return "添加成功";
    }
}
