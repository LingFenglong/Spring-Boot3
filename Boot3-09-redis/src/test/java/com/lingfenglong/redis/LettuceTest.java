package com.lingfenglong.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LettuceTest {
    @Test
    void stringTest() {
        RedisURI uri = RedisURI.builder()
                .withHost("192.168.144.132")
                .withPort(6379)
                .withAuthentication("default", "147258369")
                .build();

        RedisClient client = RedisClient.create(uri);
        StatefulRedisConnection<String, String> connect = client.connect();

        RedisCommands<String, String> commands = connect.sync();
        commands.set("lettuce", "hello from lettuce");
        String s = commands.get("lettuce");
        System.out.println("s = " + s);

        connect.close();
        client.close();

    }
}
