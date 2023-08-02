package com.lingfenglong.ssm.controller;

import com.lingfenglong.robot.service.Robot;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Tag(name = "Robot", description = "会和你说hello的robot")
@Controller
public class RobotController {
    private final Robot robot;

    public RobotController(Robot robot) {
        this.robot = robot;
    }

    @Operation(summary = "robot说hello", description = "robot会和你说hello")
    @ResponseBody
    @GetMapping("/hello")
    public String sayHello() {
        return robot.sayHello();
    }
}
