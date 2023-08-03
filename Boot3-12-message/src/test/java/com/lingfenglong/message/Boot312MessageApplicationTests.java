package com.lingfenglong.message;

import com.lingfenglong.message.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.StopWatch;

import java.util.concurrent.CompletableFuture;

@SpringBootTest
class Boot312MessageApplicationTests {

	@Autowired
	private KafkaTemplate<Object, Object> kafkaTemplate;

	// 发送消息测试
	@Test
	void contextLoads() {
		StopWatch stopWatch = new StopWatch();
		CompletableFuture[] futures = new CompletableFuture[10000];

		stopWatch.start();
		for (int i = 0; i < 10000; i++) {
			CompletableFuture<SendResult<Object, Object>> future = kafkaTemplate.send("news", "haha", "哈哈哈");
			futures[i] = future;
		}

		CompletableFuture.allOf(futures).join();
		stopWatch.stop();
		long timeMillis = stopWatch.getLastTaskTimeMillis();
		System.out.println("10000消息发送完成，用时" + timeMillis + "ms");
	}

	@Test
	void testAddPerson() {
		CompletableFuture<SendResult<Object, Object>> future = kafkaTemplate.send("news", "person1", new Person(1L, "zhangsan", "abc@qq.com"));
		future.join();
	}

	// 接收消息测试
	void testConsumer() {
		
	}

}
