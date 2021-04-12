package com.ustc.dao;

import com.ustc.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper //指定这是一个操作数据库的mapper，需要导入MyBatis依赖包
@Repository
public interface UserDao {

    @Insert("insert into user(name,role) values(#{name},#{role})")
    public boolean addUser(User user);

    @Select("select * from user where id=#{id}")
    public User findUserById(int id);

    @Update("update user set name=#{name},role=#{role} where id=#{id}")
    public boolean updateUser(User user);

    @Delete("delete from user where id=#{id}")
    public boolean deleteUserById(Integer id);

    @Select("select * from user")
    public List<User> findAllUser();
}
