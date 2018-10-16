package com.da2win.springbootlesson11.consumer;

import com.da2win.springbootlesson11.domain.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消费者监听
 */
@Component
public class ConsumerListner {

    @KafkaListener(topics = "sf-3")
    public void consumer(String message) {
        System.out.println(message);
    }

    @KafkaListener(topics = "sf-users")
    public void consumeUser(User message) {
        System.err.println(message);
    }
}
