package com.atguigu.springboot.dao;

import com.atguigu.springboot.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

//SpringBoot框架集成Spring data jpa框架，持久化层开发，只需要继承父接口。
//JpaRepository接口，已经提供好了基本的CRUD方法。可以直接使用这些方法完成数据操作。
public interface UserJpaDao extends JpaRepository<User,Integer> {

}
