package com.example.springbootdemo.cookie;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * TODO
 *
 * @author czq
 * @date 2021/6/8 16:35
 */
@SpringBootTest
@Ignore
@Slf4j
public class test{

    @Test
    public void testCookie (){
        log.info("开始执行");
    }

    @Test
    public void test(){
        List<Map<String,Object>> list = new ArrayList<>();
        List<Map<String,Object>> list1 = new ArrayList<>();
        for(int i=0;i<2;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("姓名","zhangsan"+i);
            map.put("地址","龙岗路"+i);
            list.add(map);
        }
        log.info("开始集合{}",list);
        String as = JSON.toJSONString(list);
        log.info("字符串{}",as);
        JSONArray re = JSONObject.parseArray(as);
        log.info("结束集合参数{}",re.getJSONObject(0).get("姓名"));
        for (int j=0;j<re.size();j++){
            Map<String,Object> map1 = re.getJSONObject(j);
            list1.add(map1);
        }
       log.info("新建集合{}",list1);
       log.info("新建集合第一个参数：{}",list1.get(0).get("姓名"));
    }
}
