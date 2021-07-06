package com.example.springbootdemo.commom;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * TODO
 *
 * @author czq
 * @date 2021/6/15 17:44
 */
public class Main {
    public static void main(String[] args) {
        String workData = "{\"data\":null,\"msg\": \"请求成功\",\"code\": \"1\"}";
        cn.hutool.json.JSONObject jsonObject = JSONUtil.parseObj(workData);
        JSONObject dataArray = jsonObject.getJSONObject("data");
        String code = jsonObject.getStr("code");
        System.out.println(code);
        for(int i =0;i<3;i++){
            if(dataArray.isEmpty()&&i==1){
                continue;
            }
            System.out.println("打印："+i);
        }

    }
}
