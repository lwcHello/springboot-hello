package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;
import java.util.*;

@Controller
public class ThymeleafController {
    @RequestMapping("/demo1")
    public String demo1(Model model){
        System.out.println ("我好帅！");
        model.addAttribute ("hello", "welcome Thymeleaf ");

        //集合数据
        List<User> users = new ArrayList<User>();
        users.add(new User("张三","123","深圳"));
        users.add(new User("李四","123","北京"));
        users.add(new User("王五","123","武汉"));
        model.addAttribute("users",users);

        //Map定义
        Map<String,Object> dataMap = new HashMap<String,Object> ();
        dataMap.put("No","123");
        dataMap.put("name","深圳");
        model.addAttribute("dataMap",dataMap);

        //存储一个数组
        String[] names = {"张三","李四","王五"};
        model.addAttribute("names",names);

        //日期
        model.addAttribute("now",new Date ());

        //if条件
        model.addAttribute("age",22);

        return "demo1";
    }

}
