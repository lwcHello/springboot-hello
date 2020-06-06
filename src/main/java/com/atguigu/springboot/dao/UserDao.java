package com.atguigu.springboot.dao;

import com.atguigu.springboot.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper  //接口代理对象由MyBatis框架管理。
@Repository //接口代理对象由Spring IOC 容器管理。 配合扫描包组件 @MapperScan("com.atguigu.springboot.dao")
public interface UserDao {

    //@Insert("")
    //@Delete("")
    //@Update("")
    @Select("select * from user")
    public List<User> findAll();
}
