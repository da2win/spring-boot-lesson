package com.da2win.springbootlesson19.controller;

import com.da2win.springbootlesson19.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Darwin
 * @Date 2018/11/10 10:44
 */
@RestController
public class PersonController {

    @Autowired
    private Person person;

    @GetMapping("/person")
    public Person person() {
        return person;
    }
}
