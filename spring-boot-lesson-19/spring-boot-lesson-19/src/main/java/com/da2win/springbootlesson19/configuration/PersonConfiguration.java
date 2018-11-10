package com.da2win.springbootlesson19.configuration;

import com.da2win.springbootlesson19.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 *
 * {@link Person} Bean 配置
 * @Author Darwin
 * @Date 2018/11/10 9:32
 */
@Configuration
public class PersonConfiguration {

    @Bean("primaryPerson")
    @Primary
    public Person person() {
        Person person = new Person();

        person.setId(1L);
        person.setName("达尔文");
        person.setAge(25);

        return person;
    }
}
