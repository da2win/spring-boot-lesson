package com.da2win.springbootlesson18.configuration;

import com.da2win.springbootlesson18.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Author Darwin
 * @Date 2018/11/7 10:21
 */
@Configuration
public class PersonConfiguration {

    @Bean
    @Profile("prod")
    public Person pedro() {
        Person person = new Person();
        return person;
    }

    @Bean
    @Profile("test")
    public Person hazard() {
        Person person = new Person();
        return person;
    }
}
