package com.lingfenglong.robot.annotation;

import com.lingfenglong.robot.RobotAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(RobotAutoConfiguration.class)
public @interface EnableRobot {
}