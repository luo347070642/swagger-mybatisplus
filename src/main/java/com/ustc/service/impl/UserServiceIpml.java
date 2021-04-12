package com.ustc.service.impl;

import com.ustc.dao.UserDao;
import com.ustc.entity.User;
import com.ustc.service.RedisLock;
import com.ustc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceIpml implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    private RedisLock redisLock;

    @Override
    @Transactional
    public String seckill(Integer id)throws RuntimeException {
        //加锁
        long time = System.currentTimeMillis() + 1000*10;  //超时时间：10秒，最好设为常量

        boolean isLock = redisLock.lock(String.valueOf(id), String.valueOf(time));
        if(!isLock){
            throw new RuntimeException("人太多了，换个姿势再试试~");
        }

        //查库存
//        User user = userDao.findUserById(id);
        System.out.println(String.valueOf(id)+ "----" +time);
        //写入订单表
        //减库存

        //解锁
        redisLock.unlock(String.valueOf(id),String.valueOf(time));

        return "";
    }
    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }
}
