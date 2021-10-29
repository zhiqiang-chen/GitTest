package com.example.springbootdemo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdemo.entity.UserInfoEntity;
import com.example.springbootdemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * TODO
 *
 * @author czq
 * @date 2021/6/11 10:33
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 根据ID获取用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:34
     * @Param  userId  用户ID
     * @Return UserInfoEntity 用户实体
     */
    @RequestMapping("/getInfo")
    public UserInfoEntity getInfo(String userId){
//        UserInfoEntity userInfoEntity = userInfoService.getById(userId);
        UserInfoEntity userInfoEntity = userInfoService.queryTest(userId);
        return userInfoEntity;
    }
    /**
     * 查询全部信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:35
     * @Param  userId  用户ID
     * @Return List<UserInfoEntity> 用户实体集合
     */
    @RequestMapping("/getList")
    public List<UserInfoEntity> getList(){
        List<UserInfoEntity> userInfoEntityList = userInfoService.list();
        return userInfoEntityList;
    }
    /**
     * 分页查询全部数据
     * @Author Sans
     * @CreateTime 2019/6/8 16:37
     * @Return IPage<UserInfoEntity> 分页数据
     */
    @RequestMapping("/getInfoListPage")
    public IPage<UserInfoEntity> getInfoListPage(){
        //需要在Config配置类中配置分页插件
        IPage<UserInfoEntity> page = new Page<>();
        page.setCurrent(5); //当前页
        page.setSize(1);    //每页条数
        page = userInfoService.page(page);
        return page;
    }
    /**
     * 根据指定字段查询用户信息集合
     * @Author Sans
     * @CreateTime 2019/6/8 16:39
     * @Return Collection<UserInfoEntity> 用户实体集合
     */
    @RequestMapping("/getListMap")
    public Collection<UserInfoEntity> getListMap(){
        Map<String,Object> map = new HashMap<>();
        //kay是字段名 value是字段值
        map.put("age",20);
        Collection<UserInfoEntity> userInfoEntityList = userInfoService.listByMap(map);
        return userInfoEntityList;
    }
    /**
     * 新增用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:40
     */
    @RequestMapping("/saveInfo")
    public Boolean saveInfo(){
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setNameAs("小龙");
        userInfoEntity.setSkill("JAVA");
        userInfoEntity.setAge(18);
        userInfoEntity.setFraction(59L);
        userInfoEntity.setEvaluate("该学生是一个在改BUG的码农");
        Boolean flag = userInfoService.save(userInfoEntity);
        return flag;
    }
    /**
     * 批量新增用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:42
     */
    @RequestMapping("/saveInfoList")
    public Boolean saveInfoList(){
        //创建对象
        UserInfoEntity sans = new UserInfoEntity();
        sans.setNameAs("Sans");
        sans.setSkill("睡觉");
        sans.setAge(18);
        sans.setFraction(60L);
        sans.setEvaluate("Sans是一个爱睡觉,并且身材较矮骨骼巨大的骷髅小胖子");
        UserInfoEntity papyrus = new UserInfoEntity();
        papyrus.setNameAs("papyrus");
        papyrus.setSkill("JAVA");
        papyrus.setAge(18);
        papyrus.setFraction(58L);
        papyrus.setEvaluate("Papyrus是一个讲话大声、个性张扬的骷髅，给人自信、有魅力的骷髅小瘦子");
        //批量保存
        List<UserInfoEntity> list =new ArrayList<>();
        list.add(sans);
        list.add(papyrus);
        Boolean flag = userInfoService.saveBatch(list);
        return flag;
    }
    /**
     * 更新用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:47
     */
    @RequestMapping("/updateInfo")
    public Boolean updateInfo(){
        //根据实体中的ID去更新,其他字段如果值为null则不会更新该字段,参考yml配置文件
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setId(1L);
        userInfoEntity.setAge(19);
        Boolean flag = userInfoService.updateById(userInfoEntity);
        return flag;
    }
    /**
     * 新增或者更新用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:50
     */
    @RequestMapping("/saveOrUpdateInfo")
    public Boolean saveOrUpdate(){
        //传入的实体类userInfoEntity中ID为null就会新增(ID自增)
        //实体类ID值存在,如果数据库存在ID就会更新,如果不存在就会新增
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setId(1L);
        userInfoEntity.setAge(20);
        Boolean flag = userInfoService.saveOrUpdate(userInfoEntity);
        return flag;
    }
    /**
     * 根据ID删除用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:52
     */
    @RequestMapping("/deleteInfo")
    public Boolean deleteInfo(String userId){
        Boolean flag = userInfoService.removeById(userId);
        return flag;
    }
    /**
     * 根据ID批量删除用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:55
     */
    @RequestMapping("/deleteInfoList")
    public Boolean deleteInfoList(){
        List<String> userIdlist = new ArrayList<>();
        userIdlist.add("12");
        userIdlist.add("13");
        Boolean flag = userInfoService.removeByIds(userIdlist);
        return flag;
    }
    /**
     * 根据指定字段删除用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:57
     */
    @RequestMapping("/deleteInfoMap")
    public Boolean deleteInfoMap(){
        //kay是字段名 value是字段值
        Map<String,Object> map = new HashMap<>();
        map.put("skill","删除");
        map.put("fraction",10L);
        Boolean flag = userInfoService.removeByMap(map);
        return flag;

    }

}
