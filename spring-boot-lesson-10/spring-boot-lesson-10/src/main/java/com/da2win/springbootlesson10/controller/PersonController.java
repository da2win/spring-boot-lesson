package com.da2win.springbootlesson10.controller;

import com.da2win.springbootlesson10.entity.Person;
import com.da2win.springbootlesson10.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/save")
    public Person save(@RequestBody Person person) {
        personRepository.savePerson(person);

        return person;
    }

    @GetMapping("/get/{id}")
    public Person get(@PathVariable String id) {
        return personRepository.findPerson(id);
    }
}
