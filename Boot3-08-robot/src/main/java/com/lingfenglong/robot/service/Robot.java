package com.lingfenglong.robot.service;

import com.lingfenglong.robot.properties.RobotProperties;

public class Robot {
    private final RobotProperties robotProperties;

    public Robot(RobotProperties robotProperties) {
        this.robotProperties = robotProperties;
    }

    public String sayHello() {
        return "Hello " + robotProperties.getUsername() + "!";
    }
}