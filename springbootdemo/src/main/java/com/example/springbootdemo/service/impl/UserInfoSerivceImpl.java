package com.example.springbootdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootdemo.dao.UserInfoDao;
import com.example.springbootdemo.entity.UserInfoEntity;
import com.example.springbootdemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * TODO
 *
 * @author czq
 * @date 2021/6/11 10:30
 */
@Service
public class UserInfoSerivceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    public UserInfoEntity queryTest(String userId) {
        UserInfoEntity userInfoEntity = userInfoDao.queryTest(userId);
        return userInfoEntity;
    }
}
