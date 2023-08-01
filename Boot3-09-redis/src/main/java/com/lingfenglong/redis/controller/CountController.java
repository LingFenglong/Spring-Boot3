package com.lingfenglong.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {

    private StringRedisTemplate redisTemplate;

    @Autowired
    public CountController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/count")
    public String count() {
        Long count = redisTemplate.opsForValue().increment("count");
        return "访问了[" + count + "]次";
    }
}
