package com.example.springbootdemo.commom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO
 *
 * @author czq
 * @date 2021/2/18 11:47
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "index";
    }

}
