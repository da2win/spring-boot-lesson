package com.da2win.springbootlesson3.rest;

import com.da2win.springbootlesson3.controller.User;
import org.springframework.web.client.RestTemplate;

public class RestClient {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
//        String content = restTemplate.getForObject("http://localhost:8888/json/user", String.class);
        User content = restTemplate.getForObject("http://localhost:8888/json/user", User.class);
        System.out.println(content);
    }
}
