package com.lingfenglong.boot3androidokhttptest.controller;

import com.lingfenglong.boot3androidokhttptest.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "success";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        file.transferTo(new File("D:/" + file.getOriginalFilename()));
        return "success upload";
    }
}
