package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.bean.User;
import com.atguigu.springboot.dao.UserDao;
import com.atguigu.springboot.dao.UserJpaDao;
import com.atguigu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
//@Transactional(readOnly = true)
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired //自动装配。先byType再byName
          //@Resource //JDK提供的。自动装配。先byName再byType
          UserDao userDao;

  //@Transactional(isolation = Isolation.DEFAULT)
  @Override
  public List<User> findAll() {
    return userDao.findAll();
  }

  @Autowired
  UserJpaDao userJpaDao;

  @Autowired
  RedisTemplate redisTemplate; //操作任何键值类型。
  @Autowired
  StringRedisTemplate stringRedisTemplate; //操作字符串类型键值
  /**
   * 查询所有：如果缓存中有数据，从缓存中获取。如果缓存中没有，那么，我们从哪个数据库中获取。
   */
  @Override
  public List<User> findUsers() {
    // redis的key
    String key = "alluser";
    // 先查询redis中是否有数据，如果有直接返回redis的数据
    List<User> users = (List<User>) redisTemplate.boundValueOps(key).get();
    if (users!=null) {
      System.out.println("从Redis中获取缓存数据="+users);
      return users;
    }

    // 如果没有，查询数据库
    users = userJpaDao.findAll();
    // 将数据库数据存入到redis中
    if (users != null && users.size()>0) {
      System.out.println("从数据库中获取数据存放到Redis缓存="+users);
      redisTemplate.boundValueOps(key).set(users);
    }
    return users;

  }
  /**
   * 根据id查询
   */
  @Override
  public User findUserById(Integer id) {
    return userJpaDao.findById(id).get();
  }
  /**
   * 保存
   */
  @Override
  public void saveUser(User user) {
    userJpaDao.save(user);
  }
  /**
   * 更新
   */
  @Override
  public void updateUser(User user) {
    userJpaDao.save(user);
  }
  /**
   * 根据id删除
   */
  @Override
  public void deleteUserById(Integer id) {
    userJpaDao.deleteById(id);
  }

}
