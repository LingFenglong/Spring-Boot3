package com.lingfenglong.redis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class Boot309RedisApplicationTests {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void stringTest() {
        redisTemplate.opsForValue().set("stringTest", "success");
        Assertions.assertEquals(redisTemplate.opsForValue().get("stringTest"), "success");
    }

    @Test
    void listTest() {
        String listName = "list";
        redisTemplate.opsForList().leftPush(listName, "1");
        redisTemplate.opsForList().leftPush(listName, "2");
        redisTemplate.opsForList().leftPush(listName, "3");
        redisTemplate.opsForList().leftPush(listName, "4");
        redisTemplate.opsForList().leftPush(listName, "5");

        for (int i = 1; i <= 5; i++) {
            Assertions.assertEquals(redisTemplate.opsForList().rightPop(listName), String.valueOf(i));
        }
    }

    @Test
    void testSet() {
        String setName= "set";
        redisTemplate.opsForSet().add(setName, "1", "2", "3");
    }

    @Test
    void testZSet() {
        String zSetName = "zset";
        redisTemplate.opsForZSet().add(zSetName, "5", 5);
        redisTemplate.opsForZSet().add(zSetName, "2", 2);
        redisTemplate.opsForZSet().add(zSetName, "1", 1);
        redisTemplate.opsForZSet().add(zSetName, "3", 3);
        redisTemplate.opsForZSet().add(zSetName, "4", 4);
    }

    @Test
    void testMap() {
        String mapName = "map";
        redisTemplate.opsForHash().put(mapName, "1", "a");
        redisTemplate.opsForHash().put(mapName, "2", "b");
        redisTemplate.opsForHash().put(mapName, "3", "c");
    }

}
