package com.example.springbootdemo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootdemo.dao.UserInfoDao;
import com.example.springbootdemo.entity.UserInfoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @author czq
 * @date 2021/6/11 11:54
 */
@Slf4j
@Service
@Transactional
public class TestService {
    @Autowired
    private UserInfoDao userInfoDao;

    public UserInfoEntity getById(String userId) {
        UserInfoEntity userInfoEntity = userInfoDao.selectById(userId);
        return userInfoEntity;
    }
}
