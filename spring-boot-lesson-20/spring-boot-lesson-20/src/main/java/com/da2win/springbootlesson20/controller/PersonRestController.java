package com.da2win.springbootlesson20.controller;

import com.da2win.springbootlesson20.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Darwin
 * @Date 2018/11/10 15:45
 */
@RestController
public class PersonRestController {

    private final Person person;

    @Autowired
    public PersonRestController(Person person) {
        this.person = person;
    }

    @GetMapping("/person")
    public Person person() {
        return person;
    }
}
