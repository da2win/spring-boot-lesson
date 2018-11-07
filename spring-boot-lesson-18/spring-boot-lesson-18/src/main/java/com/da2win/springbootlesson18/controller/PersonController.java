package com.da2win.springbootlesson18.controller;

import com.da2win.springbootlesson18.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * {@link Person} {@link RestController}
 * @Author Darwin
 * @Date 2018/11/7 9:12
 */
@RestController
public class PersonController implements EnvironmentAware {

    @Autowired
    @Qualifier("person")
    private Person person;

    @Value("${person.id}")
    private Long id;

    @Value("${person.name:达尔文}")
    private String name;

    private Integer age;

    @GetMapping("/person/darwin")
    public Person person() {
        return person;
    }

    @GetMapping("person/darwin/map")
    public Map<String, Object> darwinData() {
        Map<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("name", name);
        data.put("age", age);
        return data;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.age = environment.getProperty("person.age", Integer.class);
    }
}
