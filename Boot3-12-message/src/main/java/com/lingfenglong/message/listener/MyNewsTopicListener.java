package com.lingfenglong.message.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class MyNewsTopicListener {
    @KafkaListener(topics = "news", groupId = "A")
    public void consumeMsg(ConsumerRecord record) {
        System.out.println(record.key() + "  " + record.value());
    }

    @KafkaListener(groupId = "B", topicPartitions = {
            @TopicPartition(topic = "news", partitionOffsets = {
                @PartitionOffset(partition = "0", initialOffset = "0")
            })
    })
    public void consumeAllMsg(ConsumerRecord record) {
        System.out.println(record.key() + "  " + record.value());
    }
}