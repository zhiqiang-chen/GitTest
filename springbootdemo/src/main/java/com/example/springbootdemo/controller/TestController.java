package com.example.springbootdemo.controller;

import com.bonc.ioc.common.util.AppReply;
import com.example.springbootdemo.commom.Hello;
import com.example.springbootdemo.entity.ConfigBean;
import com.example.springbootdemo.entity.UserInfoEntity;
import com.example.springbootdemo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author czq
 * @date 2021/6/11 11:51
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private ConfigBean configBean;
    @Autowired
    private Hello hello;

    @RequestMapping("/getInfo")
    public AppReply getInfo(String userId){
//        UserInfoEntity userInfoEntity = testService.getById(userId);
        List<Map<String,Object>> list = testService.getInfo(userId);
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        return AppReply.success(map);
    }
    @RequestMapping("/mythread")
    public AppReply mythread(){
        hello.tesTask(10);
        hello.stringTask("5");
        return AppReply.success();
    }
    @RequestMapping("/getConfig")
    public AppReply getConfig(){
        String result = configBean.getName()+configBean.getWant();
        log.info("配置参数：{}",result);
        return AppReply.success();
    }
}
