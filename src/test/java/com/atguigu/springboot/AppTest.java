package com.atguigu.springboot;

import com.atguigu.springboot.bean.User;
import com.atguigu.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith (SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    UserService userService;

    @Autowired
    DataSource dataSource;

    /*
     * HikariDataSource 默认数据源，性能很高
     * DruidDataSource 使用很高，很稳定
     */
    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void testFindAll(){
        List<User> list = userService.findAll ();
     for (User userList :list){
         System.out.println (userList);
     }
    }
}
