package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.service.RedisService;
import com.example.springbootdemo.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


/**
 * TODO redis测试
 *
 * @author czq
 * @date 2021/6/2 17:17
 */
@RestController
@Slf4j
public class RedisController {
    @Autowired
    private RedisService redisService;
    @Autowired
    private RedisUtils redisUtils;
    /**
     * description: 依据标识获取缓存值
     * date: 2021/6/3 15:52
     * author: czq
     * @param:
     * @return com.example.springbootdemo.entity.User
     */
    @RequestMapping("/getUser")
    public User getUser(){
        String name="quellanq";
        return redisService.getUser(name);
    }
    /**
     * description: 添加缓存
     * date: 2021/6/3 15:52
     * author: czq
     * @param :
     * @return com.example.springbootdemo.entity.User
     */
    @RequestMapping("/setUser")
    public String setUser(){
        User user=new User("aa@qq.com","quellan","123456","朱",System.currentTimeMillis()+"",1L);
        redisService.setUser(user);
        return "添加成功";
    }
    /**
     * description: 依据指定id从缓存获取数据，若缓存为空，则从数据库取值，并插入缓存
     * date: 2021/6/3 15:56
     * author: czq
     * @param: id
     * @return java.lang.String
     */
    @RequestMapping(value = "/redisTest/{id}")
    public String hello(@PathVariable(value = "id") String id){
        //查询缓存中是否存在
        boolean hasKey = redisUtils.exists(id);
        String str = "";
        if(hasKey){
            //获取缓存
            Object object =  redisUtils.get(id);
            log.info("从缓存获取的数据"+ object);
            str = object.toString();
        }else{
            //从数据库中获取信息
            log.info("从数据库中获取数据");
            str = redisService.test();
            //空结果进行缓存,避免缓存穿透；设置较短的过期时间
            if(str==""||str==null){
                redisUtils.set(id,"",30L, TimeUnit.SECONDS);
            }else {
                //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
                redisUtils.set(id,str,10L, TimeUnit.MINUTES);
            }
            log.info("数据插入缓存" + str);

        }
        return str;
    }

}
