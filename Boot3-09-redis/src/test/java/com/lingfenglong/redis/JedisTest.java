package com.lingfenglong.redis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.args.GeoUnit;
import redis.clients.jedis.params.GeoRadiusParam;
import redis.clients.jedis.resps.GeoRadiusResponse;

import java.util.List;

@SpringBootTest
public class JedisTest {

    @Test
    void stringTest() {
        Jedis jedis = new Jedis("192.168.144.132", 6379);
        jedis.auth("147258369");

        jedis.set("jedis", "hello form jedis");
        String s = jedis.get("jedis");
        System.out.println("s = " + s);

        jedis.close();
    }

    @Test
    void geo() {
        Jedis jedis = new Jedis("192.168.144.132", 6379);
        jedis.auth("147258369");

        jedis.geoadd("city",80.00, 80.00, "石家庄");
        jedis.geoadd("city",81.00, 81.00, "kd");
        jedis.geoadd("city",82.00, 82.00, "zsj");

        Double dist = jedis.geodist("city", "kd", "zsj", GeoUnit.KM);
        System.out.println("dist = " + dist);

        List<GeoRadiusResponse> geoRadiusResponses = jedis.georadiusByMember("city", "kd", 1000F, GeoUnit.KM, new GeoRadiusParam().count(5).withDist().withHash());
        System.out.println("geoRadiusResponses = " + geoRadiusResponses);

        jedis.close();
    }
}
