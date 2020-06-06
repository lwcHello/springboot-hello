package com.atguigu.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//等价于@Controller+@ResponseBody

public class QuickStartController {
//    @Value("${person.name}")
//    private String name;
//
//    @Value("${person.age}")
//    private String age;

    @RequestMapping("/hello")
    public  String hello(){
        return "ok";
    }
}
