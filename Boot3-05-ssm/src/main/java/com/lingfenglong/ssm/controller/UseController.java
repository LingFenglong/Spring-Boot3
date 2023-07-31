package com.lingfenglong.ssm.controller;

import com.lingfenglong.ssm.bean.User;
import com.lingfenglong.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UseController {
    private UserMapper userMapper;

    @Autowired
    public UseController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @ResponseBody
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        User user = userMapper.getUserById(id);
        System.out.println(user);
        return user;
    }
}
