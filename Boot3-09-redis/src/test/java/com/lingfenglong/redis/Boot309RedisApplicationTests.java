package com.lingfenglong.redis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

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

    @Test
    void hyperLogLogTest() {
        redisTemplate.opsForHyperLogLog().add("number", "1", "3", "3", "3", "3", "3", "3", "5", "7", "9", "11");
        Long size = redisTemplate.opsForHyperLogLog().size("number");
        System.out.println("size = " + size);
    }

    @Test
    void bitMapTest() {
        ValueOperations<String, String> forValue = redisTemplate.opsForValue();
        forValue.setBit("zs", 0, true);
        forValue.setBit("zs", 1, true);
        System.out.println(forValue.getBit("zs", 0));
        System.out.println(forValue.getBit("zs", 1));
        System.out.println(forValue.getBit("zs", 2));
        System.out.println(forValue.getBit("zs", 3));
        System.out.println(forValue.getBit("zs", 4));

        System.out.println("forValue.size(\"zs\") = " + forValue.size("zs"));
    }
}
