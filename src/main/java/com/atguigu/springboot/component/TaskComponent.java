package com.atguigu.springboot.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component//声明定时任务的一个组件
public class TaskComponent {
    //设置定时间隔时间
    @Scheduled(fixedDelay = 3000)
    public void  printTime(){
        SimpleDateFormat sdf=new SimpleDateFormat ("yyy-MM--dd HH:mm:ss");
        String time = sdf.format (new Date ());
        System.out.println (time);
    }
}
