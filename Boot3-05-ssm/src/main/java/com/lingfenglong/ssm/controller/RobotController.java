package com.lingfenglong.ssm.controller;

import com.lingfenglong.robot.service.Robot;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RobotController {
    private final Robot robot;

    public RobotController(Robot robot) {
        this.robot = robot;
    }

    @ResponseBody
    @GetMapping("/hello")
    public String sayHello() {
        return robot.sayHello();
    }
}
