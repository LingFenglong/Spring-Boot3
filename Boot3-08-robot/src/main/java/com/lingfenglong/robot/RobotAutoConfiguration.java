package com.lingfenglong.robot;

import com.lingfenglong.robot.properties.RobotProperties;
import com.lingfenglong.robot.service.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;


@AutoConfiguration
@ConfigurationPropertiesScan(basePackageClasses = RobotProperties.class)
public class RobotAutoConfiguration {
    private final RobotProperties robotProperties;

    @Autowired
    public RobotAutoConfiguration(RobotProperties robotProperties) {
        this.robotProperties = robotProperties;
    }

    @Bean
    public Robot robot() {
        return new Robot(robotProperties);
    }
}