package com.example.springbootdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdemo.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author czq
 * @date 2021/6/11 10:23
 */
@Mapper
@Repository
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {
    UserInfoEntity queryTest(String userId);
}
