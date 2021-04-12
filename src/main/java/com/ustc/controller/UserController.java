package com.ustc.controller;

import com.ustc.entity.User;
import com.ustc.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "增加一个用户") // 接口文档显示内容
    @PostMapping("/add")
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @ApiOperation(value = "增加一个用户1") // 接口文档显示内容
    @PostMapping("/add1")
    public boolean addUser1(@RequestBody User user) {
        return userService.addUser(user);
    }

    @ApiOperation(value = "根据id查询用户") // 接口文档显示内容
    @GetMapping("/find/{id}")
    public User findUserById(@PathVariable("id") int id) {
        return userService.findUserById(id);
    }

    @ApiOperation(value = "更新用户") // 接口文档显示内容
    @PutMapping("/update")
    public boolean updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @ApiOperation(value = "根据id删除用户") // 接口文档显示内容
    @DeleteMapping("/delete/{id}")
    public boolean deleteUserById(@PathVariable("id") int id) {
        return userService.deleteUserById(id);
    }

    @ApiOperation(value = "查询所有用户") // 接口文档显示内容
    @GetMapping("/findAll")
    public List<User> findAllUser() {
        return userService.findAllUser();
    }
}
