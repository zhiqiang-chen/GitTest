package com.example.springbootdemo.controller;

import com.bonc.ioc.common.util.AppReply;
import com.example.springbootdemo.entity.UserInfoEntity;
import com.example.springbootdemo.service.TestService;
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
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/getInfo")
    public AppReply getInfo(String userId){
//        UserInfoEntity userInfoEntity = testService.getById(userId);
        List<Map<String,Object>> list = testService.getById(userId);
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        return AppReply.success(map);
    }
}
