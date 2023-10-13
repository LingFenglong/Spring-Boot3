package com.lingfenglong.redis.controller;

import com.lingfenglong.redis.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CountController {

    private final StringRedisTemplate stringRedisTemplate;
    private final RedisTemplate<Object, Object> redisTemplate;


    @Autowired
    public CountController(StringRedisTemplate stringRedisTemplate, RedisTemplate<Object, Object> redisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.redisTemplate = redisTemplate;
    }

    @Autowired

    @GetMapping("/count")
    public String count() {
        Long count = stringRedisTemplate.opsForValue().increment("count");
        return "访问了[" + count + "]次";
    }


    //@GetMapping("/person/save")
    //public String savePerson(@RequestParam ) {
    //    return "person/save";
    //}

    @GetMapping("/person/save")
    public String savePerson() {
        String mapName = "persons";

        Person zhangsan = new Person(1L, "zhangsan", 18, new Date());
        Person lisi = new Person(2L, "lisi", 19, new Date());
        Person wangwu = new Person(3L, "wangwu", 23, new Date());

        redisTemplate.opsForHash().put(mapName, zhangsan.getId(), zhangsan);
        redisTemplate.opsForHash().put(mapName, lisi.getId(), lisi);
        redisTemplate.opsForHash().put(mapName, wangwu.getId(), wangwu);

        return "OK";
    }

    @GetMapping("/person/get/all")
    public Object getAllPerson() {
        String mapName = "persons";
        return redisTemplate.opsForHash().entries(mapName);
    }
}
