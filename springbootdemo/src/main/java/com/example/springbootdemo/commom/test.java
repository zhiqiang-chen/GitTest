package com.example.springbootdemo.commom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TODO
 *
 * @author czq
 * @date 2021/6/23 17:49
 */
public class test {
    private HashMap<String,String> workUserMsgInfo=new HashMap();
    public void tsr(){
        workUserMsgInfo.put("111","111");
        workUserMsgInfo.put("222","222");
        System.out.println(workUserMsgInfo);
        workUserMsgInfo.put("333","333");
        workUserMsgInfo.clear();
    }
}
