package com.ustc.service;

import com.ustc.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserService {

    public boolean addUser(User user);

    public User findUserById(int id);

    public boolean updateUser(User user);

    public boolean deleteUserById(Integer id);

    public List<User> findAllUser();

    public String seckill(Integer id);
}
