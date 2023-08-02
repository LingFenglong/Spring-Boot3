package com.lingfenglong.ssm.controller;

import com.lingfenglong.ssm.bean.User;
import com.lingfenglong.ssm.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Tag(name = "用户管理", description = "用户的CRUD")
@Controller
public class UseController {
    private UserMapper userMapper;

    @Autowired
    public UseController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Operation(summary = "用户查询", description = "通过用户id查询用户")
    @ResponseBody
    @GetMapping("/user/{id}")
    public User getUserById(@Parameter(description = "用户的id") @PathVariable("id") Integer id) {
        User user = userMapper.getUserById(id);
        System.out.println(user);
        return user;
    }
}
