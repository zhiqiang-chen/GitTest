package com.example.springbootdemo.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootdemo.dao.UserInfoDao;
import com.example.springbootdemo.entity.UserInfoEntity;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    public List<Map<String,Object>> getById(String userId) {
        UserInfoEntity userInfoEntity = userInfoDao.selectById(userId);
        QueryWrapper<UserInfoEntity> wrapper  = new QueryWrapper<UserInfoEntity>();
        wrapper.eq(!StringUtils.isNullOrEmpty(""),"name","小兰");
        List<Map<String,Object>> a = userInfoDao.selectMaps(wrapper);
        return a;
    }
}
