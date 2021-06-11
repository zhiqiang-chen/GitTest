package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.UserInfoEntity;
import com.example.springbootdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public UserInfoEntity getInfo(String userId){
        UserInfoEntity userInfoEntity = testService.getById(userId);
        return userInfoEntity;
    }
}
