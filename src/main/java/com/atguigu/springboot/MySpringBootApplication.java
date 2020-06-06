package com.atguigu.springboot;

import com.atguigu.springboot.bean.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//声明当前项目是个Springboot项目
@MapperScan("com.atguigu.springboot.dao")
@EnableTransactionManagement//开启声明事物
@EnableScheduling//启用定时任务
@ServletComponentScan//扫描@webListener @webFilter @webServlet
@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
        //启动Tomcat服务器，内置Tomcat
        ApplicationContext act = SpringApplication.run (MySpringBootApplication.class, args);
//        for (String name :act.getBeanDefinitionNames ()){
//            System.out.println (name);
//        }

//        User user=(User)act.getBean ("user");
//        System.out.println (user);

    }
}
