package com.da2win.springbootlesson11.controller;

import com.da2win.springbootlesson11.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafkaController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("message/send")
    public String sendMessage(@RequestParam String message) {
        kafkaTemplate.send("sf-3", 0, message);
        return message;
    }

    @PostMapping("user/save")
    public User save(@RequestBody User user) {
        kafkaTemplate.send("sf-users", 0, user);
        return user;
    }
}
