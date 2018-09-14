package com.da2win.springbootlesson3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class JsonRestController {
    @Bean
    public User currentUser() {
        User user = new User();
        user.setName("JSON");
        user.setAge(24);
        return user;
    }

    @Autowired
    @Qualifier("currentUser")
    private User user;

    @GetMapping(path = "/json/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User user() {
        return user;
    }

    @GetMapping(path = "/json/user/set/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public User setUserName(@RequestParam String name) {
        user.setName(name);
        user.add(linkTo(methodOn(JsonRestController.class).setUserName(name)).withSelfRel());
        return user;
    }
}
